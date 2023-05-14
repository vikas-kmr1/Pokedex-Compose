package com.mine.pokedex.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.pokedex.data.repository.MainRepository
import com.mine.pokedex.network.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed interface HomeUiState {
    data class Success(val pokemons: List<Pokemon>) : HomeUiState
    object Error : HomeUiState
    object Loading : HomeUiState
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val  mainRepository: MainRepository
) :ViewModel(){

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    /**
     * Call getHomePhotos() on init so we can display status immediately.
     */
    init {
        getAllPokemons(0)
    }

    /**
     * Gets Home photos information from the Home API Retrofit service and updates the
     * [HomePhoto] [List] [MutableList].
     */
    fun getAllPokemons(page:Int ) {
        viewModelScope.launch {
            homeUiState = HomeUiState.Loading
            homeUiState = try {
                HomeUiState.Success(mainRepository.fetchPokemonList(page = page))
            } catch (e: IOException) {
                HomeUiState.Error
            } catch (e: HttpException) {
                HomeUiState.Error
            }
        }
    }
}
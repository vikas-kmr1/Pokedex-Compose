package com.mine.pokedex.ui.screens.pokemon_details_item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.pokedex.data.repository.DetailsRepository
import com.mine.pokedex.network.model.Pokemoninfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

sealed interface PokemonUiState {
    data class Success(val pokemonInfo: Pokemoninfo ) : PokemonUiState
    object Error : PokemonUiState
    object Loading : PokemonUiState
}

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val detailsRepository: DetailsRepository
) : ViewModel() {

    var pokemonUiState: PokemonUiState by mutableStateOf(PokemonUiState.Loading)
        private set

    init {
        getPokemonInfo("ditto")
    }

    fun getPokemonInfo(pokemonName: String) {
        viewModelScope.launch {
            pokemonUiState = PokemonUiState.Loading
            pokemonUiState = try {
                PokemonUiState.Success(detailsRepository.fetchPokemonInfo(name = pokemonName))
            } catch (e: IOException) {
                PokemonUiState.Error
            } catch (e: HttpException) {
                PokemonUiState.Error
            }
//            catch (e :Exception){
//
//            PokemonUiState.Error
//            }
        }
    }
}

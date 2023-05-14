package com.mine.pokedex.ui.screens.pokemon_details_item



import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mine.pokedex.network.model.Pokemoninfo
import com.mine.pokedex.ui.screens.home.ErrorScreen
import com.mine.pokedex.ui.screens.home.LoadingScreen
import kotlinx.coroutines.flow.StateFlow

@Composable
fun PokemonDetailsScreen(
    dominantColor: Int,
    pokemonName: String,
    detailsViewModel:PokemonDetailsViewModel,
    pokemonUiState: PokemonUiState
) {

    when (pokemonUiState) {
        is PokemonUiState.Loading -> LoadingScreen()
        is PokemonUiState.Success -> Results((pokemonUiState as PokemonUiState.Success).pokemonInfo)
        is PokemonUiState.Error -> ErrorScreen()
    }

}

@Composable
fun Results(pokemoninfo: Pokemoninfo){
    Text(pokemoninfo.name, modifier = Modifier.fillMaxSize())
}





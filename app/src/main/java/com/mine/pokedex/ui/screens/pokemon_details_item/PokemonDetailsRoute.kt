package com.mine.pokedex.ui.screens.pokemon_details_item


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import com.mine.pokedex.ui.navigation.PokemonDetailsDestination.dominantColor
import com.mine.pokedex.ui.navigation.PokemonDetailsDestination.pokemonName
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

@Composable
fun PokemonDetailsRoute(
   dominantColors: List<Color>,
   pokemonName: String,
   detailsViewModel: PokemonDetailsViewModel,
   navigateBack: () -> Unit
) {
   val pokemonUiState by rememberUpdatedState(detailsViewModel.pokemonUiState)
   LaunchedEffect(pokemonName){
      detailsViewModel.getPokemonInfo(pokemonName = pokemonName)
   }

   PokemonDetailsScreen(
      dominantColors = dominantColors,
      pokemonName = pokemonName,
      detailsViewModel = detailsViewModel,
      pokemonUiState = pokemonUiState,
      navigateBack = navigateBack
   )
}
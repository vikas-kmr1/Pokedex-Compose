package com.mine.pokedex.ui.screens.pokemon_details_item


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher

@Composable
fun PokemonDetailsRoute(
   dominantColor: Int,
   pokemonName: String,
   detailsViewModel: PokemonDetailsViewModel
) {
   val pokemonUiState by rememberUpdatedState(detailsViewModel.pokemonUiState)
   LaunchedEffect(pokemonName){
      detailsViewModel.getPokemonInfo(pokemonName = pokemonName)
   }

   PokemonDetailsScreen(
      dominantColor = dominantColor,
      pokemonName = pokemonName,
      detailsViewModel = detailsViewModel,
      pokemonUiState = pokemonUiState
   )
}
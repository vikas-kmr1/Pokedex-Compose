package com.mine.pokedex.ui


import androidx.compose.runtime.Composable
import com.mine.pokedex.ui.navigation.NavGraph
import com.mine.pokedex.ui.screens.home.HomeViewModel
import com.mine.pokedex.ui.screens.pokemon_details_item.PokemonDetailsViewModel

@Composable
fun PokedexApp(
    homeViewModel: HomeViewModel,
    detailsViewModel : PokemonDetailsViewModel
) {

    NavGraph(homeViewModel = homeViewModel, detailsViewModel = detailsViewModel)
}


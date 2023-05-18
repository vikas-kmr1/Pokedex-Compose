package com.mine.pokedex.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


@Composable
fun HomeRoute(
    homeViewModel: HomeViewModel,
    navigateToPokemonItemClicked: (List<Int>, String) -> Unit
) {

    HomeScreen(
        homeUiState = homeViewModel.homeUiState,
        navigateToPokemonItemClicked = navigateToPokemonItemClicked)
}
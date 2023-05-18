package com.mine.pokedex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mine.pokedex.ui.navigation.PokemonDetailsDestination.arguments
import com.mine.pokedex.ui.screens.home.HomeRoute
import com.mine.pokedex.ui.screens.home.HomeViewModel
import com.mine.pokedex.ui.screens.pokemon_details_item.PokemonDetailsRoute
import com.mine.pokedex.ui.screens.pokemon_details_item.PokemonDetailsViewModel
import com.mine.pokedex.ui.theme.TypePoison
import com.mine.pokedex.ui.theme.TypeSteel


@Composable
fun NavGraph(
    homeViewModel: HomeViewModel,
    detailsViewModel : PokemonDetailsViewModel,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route
    ) {

        composable(route = HomeDestination.route) {
            HomeRoute(homeViewModel = homeViewModel,
                navigateToPokemonItemClicked = { dominantColors, pokemonName ->
                    navController.navigate(PokemonDetailsDestination.route + "/${dominantColors.first()}/${dominantColors.last()}/${pokemonName}")
                })
        }

        composable(
            route = PokemonDetailsDestination.routeWithArgs,
            arguments = arguments
            //TODO :- app deep links to pokemon details
        ) { navBackStack ->
            val dominantColor = remember {
                navBackStack.arguments?.getInt(PokemonDetailsDestination.dominantColor)
                    ?: TypePoison.toArgb()
            }
            val dominantLightColor = remember {
                navBackStack.arguments?.getInt(PokemonDetailsDestination.dominantLightColor)
                    ?: TypeSteel.toArgb()
            }
            val pokemonName = remember {
                navBackStack.arguments?.getString(PokemonDetailsDestination.pokemonName)
                    ?: "Pokemon"
            }
            PokemonDetailsRoute(
                dominantColors = listOf<Color>(
                    Color(dominantColor),
                    Color(dominantLightColor)
                ),
                pokemonName = pokemonName,
                detailsViewModel = detailsViewModel,
                {navController.navigateUp()}
            )
        }
    }

}

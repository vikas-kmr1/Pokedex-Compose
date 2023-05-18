package com.mine.pokedex.ui.navigation

import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.mine.pokedex.R
import com.mine.pokedex.ui.theme.TypePoison

interface NavDestinations {
    val route: String
    val titleRes: Int
}

object HomeDestination : NavDestinations {
    override val route: String = "home"
    override val titleRes: Int = R.string.app_name
}

object PokemonDetailsDestination : NavDestinations {
    override val route: String = "pokemon_detail"
    override val titleRes: Int = R.string.pokemon_details
    const val dominantColor: String = "dominantColor"
    const val dominantLightColor: String = "dominantLightColor"
    const val pokemonName: String = "pokemonName"
    val routeWithArgs = "$route/{$dominantColor}/{$dominantLightColor}/{$pokemonName}"

    //TODO :- app deep links to pokemon details
    val deepLinks = listOf(
        navDeepLink {
            uriPattern = "$route/{$dominantColor}/{$dominantLightColor}/{$pokemonName}"
        }
    )

    val arguments = listOf(
        navArgument(name = dominantColor) {
            type = NavType.IntType
            defaultValue = TypePoison.toArgb()
        },
        navArgument(name = pokemonName) {
            type = NavType.StringType
            defaultValue = "pokemon"
        }
    )

}


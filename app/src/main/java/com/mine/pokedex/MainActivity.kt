package com.mine.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.mine.pokedex.ui.PokedexApp
import com.mine.pokedex.ui.screens.home.HomeViewModel
import com.mine.pokedex.ui.screens.pokemon_details_item.PokemonDetailsViewModel
import com.mine.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the fullscreen mode using WindowCompat
        WindowCompat.setDecorFitsSystemWindows(window, false)
     //   val insetsController = WindowCompat.getInsetsController(window, window.decorView)
//        insetsController?.apply {
//            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//            hide(WindowInsetsCompat.Type.statusBars())
//        }

        setContent {
            PokedexTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val systemUiController = rememberSystemUiController()

                    val homeViewModel : HomeViewModel by viewModels()
                    val detailsViewModel : PokemonDetailsViewModel = viewModel()
                    PokedexApp(homeViewModel = homeViewModel,
                    detailsViewModel = detailsViewModel)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PokedexAppPreview() {
    PokedexTheme {

    }
}
package com.mine.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mine.pokedex.ui.PokedexApp
import com.mine.pokedex.ui.screens.home.HomeViewModel
import com.mine.pokedex.ui.screens.pokemon_details_item.PokemonDetailsViewModel
import com.mine.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars).fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
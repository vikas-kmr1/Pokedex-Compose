package com.mine.pokedex.ui.screens.home


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.mine.pokedex.network.model.Pokemon
import com.mine.pokedex.ui.components.ErrorScreen
import com.mine.pokedex.ui.components.LoadingScreen
import com.mine.pokedex.ui.components.PokedexTopAppBar
import com.mine.pokedex.ui.screens.pokemon_details_item.PokemonCard
import com.mine.pokedex.ui.screens.pokemon_details_item.PokemonImage
import com.mine.pokedex.ui.theme.TypePoison
import com.mine.pokedex.ui.theme.TypeSteel


@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    navigateToPokemonItemClicked: (List<Int>, String) -> Unit
) {
    when (homeUiState) {
        is HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Success -> Results(homeUiState.pokemons, navigateToPokemonItemClicked)
        is HomeUiState.Error -> ErrorScreen()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Results(pokemons: List<Pokemon>, navigateToPokemonItemClicked: (List<Int>, String) -> Unit) {
    Scaffold(
        topBar = { PokedexTopAppBar(searchEnable = true ) }
    ) { innerPadding ->
        LazyVerticalGrid(
            modifier = Modifier.padding(innerPadding),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(all = 5.dp)
        ) {
            items(pokemons) { pokemon ->
                PokemonCard(pokemon = pokemon) { dominantColor, pokemonName ->
                    navigateToPokemonItemClicked(dominantColor, pokemonName)
                }
            }
        }
    }
}

@Composable
fun PokemonCard(pokemon: Pokemon, navigateToPokemonItemClicked: (List<Int>, String) -> Unit) {
    val defaultColor = TypePoison
    val defaultColorLight = TypeSteel
    var dominantColor by remember { mutableStateOf(defaultColor) }
    var dominantLightColor by remember { mutableStateOf(defaultColorLight) }
    ElevatedCard(
        modifier = Modifier
            .padding(end = 10.dp, top = 5.dp, bottom = 5.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable(onClick = {
                navigateToPokemonItemClicked(
                    listOf(dominantColor.toArgb(), dominantLightColor.toArgb()),
                    pokemon.name
                )
            }),
        shape = CardDefaults.elevatedShape,

        ) {
        Column(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        dominantColor,
                        dominantLightColor
                    )
                )
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            PokemonImage(pokemon = pokemon) { c1, c2 ->
                dominantColor = c1
                dominantLightColor = c2
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = pokemon.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}

@Composable
fun PokemonImage(pokemon: Pokemon, getDominantColors: (Color, Color) -> Unit) {
    AsyncImage(
        model = ImageRequest
            .Builder(context = LocalContext.current)
            .data(pokemon.getImageUrl())
            .decoderFactory(SvgDecoder.Factory())
            .listener(
                onSuccess = { _, result ->
                    // Create the palette on a background thread.
                    Palette.Builder(result.drawable.toBitmap()).generate { palette ->
                        val dominantColor = palette?.dominantSwatch?.rgb?.let { colorVal ->
                            Color(colorVal)
                        } ?: TypePoison
                        val dominantLightColor = palette?.lightVibrantSwatch?.rgb?.let { colorVal ->
                            Color(colorVal)
                        } ?: TypeSteel

                        getDominantColors(dominantColor, dominantLightColor)


                    }


                })
            .crossfade(true)
            .build(),
        modifier = Modifier.size(120.dp),
        placeholder = null,
        contentDescription = "${pokemon.name} image",
        contentScale = ContentScale.Fit
    )
}



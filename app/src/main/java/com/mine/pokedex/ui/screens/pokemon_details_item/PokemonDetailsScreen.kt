package com.mine.pokedex.ui.screens.pokemon_details_item


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.mine.pokedex.network.model.Pokemoninfo
import com.mine.pokedex.ui.components.ErrorScreen
import com.mine.pokedex.ui.components.LoadingScreen
import com.mine.pokedex.ui.components.PokedexTopAppBar

@Composable
fun PokemonDetailsScreen(
    dominantColors: List<Color>,
    pokemonName: String,
    detailsViewModel: PokemonDetailsViewModel,
    pokemonUiState: PokemonUiState,
    navigateBack : () -> Unit
) {
    when (pokemonUiState) {
        is PokemonUiState.Loading -> LoadingScreen()
        is PokemonUiState.Success -> Results(
            (pokemonUiState as PokemonUiState.Success).pokemonInfo,
            dominantColors,
            navigateBack = navigateBack
        )

        is PokemonUiState.Error -> ErrorScreen()
    }
}

@Composable
fun Results(pokemoninfo: Pokemoninfo, dominantColors: List<Color>,navigateBack: () -> Unit) {
    PokemonCard(dominantColors = dominantColors, pokemonInfo = pokemoninfo,navigateBack=navigateBack)
}


@Composable
fun PokemonCard(dominantColors: List<Color>, pokemonInfo: Pokemoninfo,navigateBack: () -> Unit) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(brush = Brush.verticalGradient(colors = dominantColors)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            PokedexTopAppBar(title = pokemonInfo.name, color = Color.Transparent, canNavigateBack = true, id = pokemonInfo.getIdString(),
            handleNavBack = navigateBack)
            PokemonImage(pokemonInfo.getImageUrl())
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun PokemonImage(pokemonImage: String) {
    AsyncImage(
        model = ImageRequest
            .Builder(context = LocalContext.current)
            .data(pokemonImage)
            .decoderFactory(SvgDecoder.Factory())
            .crossfade(true)
            .build(),
        modifier = Modifier.size(POKEMON_IMAGE_SIZE.dp).padding(10.dp),
        placeholder = null,
        contentDescription = "pokemon image",
        contentScale = ContentScale.Fit
    )
}

const val POKEMON_IMAGE_SIZE = 220








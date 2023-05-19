package com.mine.pokedex.ui.screens.pokemon_details_item


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.mine.pokedex.R
import com.mine.pokedex.network.model.Pokemoninfo
import com.mine.pokedex.network.model.others.Type
import com.mine.pokedex.ui.components.ErrorScreen
import com.mine.pokedex.ui.components.LoadingScreen
import com.mine.pokedex.ui.components.PokedexTopAppBar
import com.mine.pokedex.ui.utils.PokemonTypeUtils

@Composable
fun PokemonDetailsScreen(
    dominantColors: List<Color>,
    pokemonName: String,
    detailsViewModel: PokemonDetailsViewModel,
    pokemonUiState: PokemonUiState,
    navigateBack: () -> Unit
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
fun Results(pokemoninfo: Pokemoninfo, dominantColors: List<Color>, navigateBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        PokemonCard(
            dominantColors = dominantColors,
            pokemonInfo = pokemoninfo,
            navigateBack = navigateBack
        )

        MiddleInfoSection(pokemonInfo = pokemoninfo)
    }
}


@Composable
fun PokemonCard(dominantColors: List<Color>, pokemonInfo: Pokemoninfo, navigateBack: () -> Unit) {
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
            PokedexTopAppBar(
                title = pokemonInfo.name,
                color = Color.Transparent,
                canNavigateBack = true,
                id = pokemonInfo.getIdString(),
                handleNavBack = navigateBack
            )
            PokemonImage(pokemonInfo.getImageUrl())
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
fun MiddleInfoSection(pokemonInfo: Pokemoninfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = pokemonInfo.name, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.ExtraBold)
        TypeChipGroup(types = pokemonInfo.types)
        Spacer(modifier = Modifier.height(10.dp))
        PhysiqueDetails(pokemonInfo = pokemonInfo)

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypeChipGroup(types: List<Type>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        types.forEach { type ->
            ElevatedAssistChip(
                label = { Text(modifier = Modifier.padding(horizontal = 20.dp),text = type.type.name) },
                onClick = {},
                enabled = false,
                colors = AssistChipDefaults.assistChipColors(
                    disabledContainerColor = PokemonTypeUtils.getTypeColor(type = type.type.name),
                    disabledLabelColor = Color.White
                ),
                shape = MaterialTheme.shapes.extraLarge
            )
        }
    }
}

@Composable
fun PhysiqueDetails(pokemonInfo: Pokemoninfo) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Box(modifier = Modifier.wrapContentSize()) {
            Image(
                modifier =Modifier.size(POKEMON_Box_SIZE.dp),
                painter = painterResource(R.drawable.weight),
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                alpha = 0.1f
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.size(POKEMON_Box_SIZE.dp).offset(y= 15.dp),
            ) {
                Text(
                    text = pokemonInfo.getWeightString(),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = stringResource(R.string.weight),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.LightGray
                )
            }
        }

        Box(modifier = Modifier.wrapContentSize()) {
            Image(
                modifier = Modifier.width((POKEMON_Box_SIZE).dp).height((POKEMON_Box_SIZE+10).dp),
                painter = painterResource(R.drawable.resize),
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                alpha = 0.1f,
                colorFilter = ColorFilter.tint(Color.White)
            )
            Column( modifier = Modifier.size( (POKEMON_Box_SIZE).dp).offset(y=10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = pokemonInfo.getHeightString(),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = stringResource(R.string.height),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.LightGray
                )
            }
        }
    }
}
private const val POKEMON_IMAGE_SIZE = 220
private const val POKEMON_Box_SIZE = 100







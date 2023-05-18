package com.mine.pokedex.ui.components

import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mine.pokedex.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexTopAppBar(
    modifier: Modifier = Modifier,
    title: String = stringResource(
        R.string.app_name
    ),
    id: String = "",
    canNavigateBack: Boolean = false,
    handleNavBack :() -> Unit = {},
    searchEnable:Boolean = false,
    onSearchClicked: () -> Unit = {},
    color: Color = MaterialTheme.colorScheme.surface
) {

    TopAppBar(
        title = { Text(text = title.capitalize(), textAlign = TextAlign.Center) },
        navigationIcon = { if (canNavigateBack) BackNavButton(handleNavBack = handleNavBack) },
        modifier = modifier,
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = color
        ),
        actions = {
            if (canNavigateBack) Text(text = id , textAlign = TextAlign.Center, style = MaterialTheme.typography.titleMedium ,modifier = Modifier.offset(x= -15.dp) )
            if(searchEnable){
                SearchButton(onSearchClicked = onSearchClicked)
            }
        }
    )
}

@Composable
fun BackNavButton(handleNavBack: () -> Unit) {
    IconButton(onClick = handleNavBack) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back nav arrow"
        )
    }
}
@Composable
fun SearchButton(onSearchClicked: () -> Unit) {
    IconButton(onClick = onSearchClicked) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search"
        )
    }
}
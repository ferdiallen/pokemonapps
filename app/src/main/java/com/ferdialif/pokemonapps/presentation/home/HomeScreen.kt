package com.ferdialif.pokemonapps.presentation.home

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ferdialif.pokemonapps.R
import com.ferdialif.pokemonapps.core.util.screenSizeResult
import com.ferdialif.pokemonapps.presentation.ui.theme.MainColorAccent
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
    onNavigateToDetailScreen: (String) -> Unit
) {
    val preferredHeight = screenSizeResult(0.25F)
    val pokemonData by viewModel.pokemonData.collectAsState()
    val searchBarState by viewModel.shouldShowSearchBar.collectAsState()
    var currentSearch by remember {
        mutableStateOf("")
    }
    val filteredResult = remember(searchBarState) {
        return@remember pokemonData.filter {
            it.name.lowercase().contains(currentSearch.lowercase())
        }
    }
    Column(modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(preferredHeight),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row {
                    Spacer(modifier = Modifier.weight(1.5F))
                    AnimatedVisibility(visible = searchBarState) {
                        Image(
                            painter = painterResource(id = R.drawable.main_logo),
                            contentDescription = ""
                        )
                    }
                    AnimatedVisibility(visible = !searchBarState) {
                        OutlinedTextField(value = currentSearch, onValueChange = {
                            currentSearch = it
                        }, shape = CircleShape, maxLines = 1)
                    }
                    Spacer(modifier = Modifier.weight(1F))
                    IconButton(onClick = {
                        viewModel.searchBarState(!searchBarState)
                    }) {
                        Icon(imageVector = Icons.Filled.Search, contentDescription = "")
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 16.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            items(pokemonData) {
                PokemonItem(image = it.image, it.name, onItemClick = {

                })
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PokemonItem(
    image: String = "",
    name: String = "",
    onItemClick: () -> Unit
) {
    Card(
        modifier = Modifier.size(200.dp),
        colors = CardDefaults.cardColors(MainColorAccent),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = onItemClick::invoke
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = image,
                contentDescription = "",
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.FillBounds
            )
            Text(
                text = name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier,
                fontSize = 17.sp
            )
        }
    }
}
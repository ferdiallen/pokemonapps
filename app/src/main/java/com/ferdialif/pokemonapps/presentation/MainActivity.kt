package com.ferdialif.pokemonapps.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.ferdialif.pokemonapps.core.navigation.Navigation
import com.ferdialif.pokemonapps.presentation.detail.DetailScreen
import com.ferdialif.pokemonapps.presentation.home.HomeScreen
import com.ferdialif.pokemonapps.presentation.ui.theme.PokemonAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonAppsTheme {
              /*Navigation(
                  modifier = Modifier.fillMaxSize()
              )*/
                DetailScreen {

                }
            }
        }
    }
}


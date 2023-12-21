package com.ferdialif.pokemonapps.presentation.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ferdialif.pokemonapps.R

@Composable
fun StartScreen(
    modifier: Modifier = Modifier,
    onNavigateToHomeScreen: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val spacingSize = remember {
        with(density) {
            (configuration.screenHeightDp / 2.5F).toDp()
        }
    }
    Column(
        modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(spacingSize))
        Text(text = "Welcome to")
        Image(
            painter = painterResource(id = R.drawable.main_logo),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.15F)
        )
        Spacer(modifier = Modifier.height(spacingSize.minus(100.dp)))
        Image(
            painter = painterResource(id = R.drawable.main_pokemon),
            contentDescription = "",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.FillBounds
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                onNavigateToHomeScreen()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF006d38)),
            modifier = Modifier
                .fillMaxWidth(0.4F)
        ) {
            Text(text = "Start", color = Color.White, modifier = Modifier.padding(vertical = 4.dp))
        }
    }
}
package com.ferdialif.pokemonapps.core.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun screenSizeResult(
    fraction: Float = 0F
): Dp {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current
    val preferredHeight = remember {
        with(density) {
            (configuration.screenHeightDp * fraction).toDp()
        }
    }
    return preferredHeight
}
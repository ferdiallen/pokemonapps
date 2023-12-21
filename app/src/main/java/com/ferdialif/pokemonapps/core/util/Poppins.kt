package com.ferdialif.pokemonapps.core.util

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.ferdialif.pokemonapps.R

val poppins = FontFamily(
    listOf(
        Font(R.font.popins_regular, weight = FontWeight.Normal),
        Font(R.font.popins_semibold, weight = FontWeight.SemiBold),
        Font(R.font.popins_bold, weight = FontWeight.Bold),
    )
)
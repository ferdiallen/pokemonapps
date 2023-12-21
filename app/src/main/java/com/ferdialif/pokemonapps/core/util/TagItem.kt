package com.ferdialif.pokemonapps.core.util

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TagItem(
    text: String = ""
) {
    Card(shape = CircleShape) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
            color = Color.White
        )
    }
}
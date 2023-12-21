package com.ferdialif.pokemonapps.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ferdialif.pokemonapps.R
import com.ferdialif.pokemonapps.core.util.TagItem
import com.ferdialif.pokemonapps.core.util.screenSizeResult
import com.ferdialif.pokemonapps.presentation.ui.theme.MainColorAccent

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit
) {
    val preferredHeight = screenSizeResult(1F)
    Column(modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(preferredHeight),
            shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp),
            colors = CardDefaults.cardColors(MainColorAccent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_pokemon),
                contentDescription = "", modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Bulbasaur", fontSize = 24.sp)
                Spacer(modifier = Modifier.weight(1F))
                LazyRow {
                    items(2) {
                        TagItem("Fire")
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }
            }
        }
    }
}


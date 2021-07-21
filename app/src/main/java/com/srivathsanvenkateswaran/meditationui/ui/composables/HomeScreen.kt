package com.srivathsanvenkateswaran.meditationui.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srivathsanvenkateswaran.meditationui.R
import com.srivathsanvenkateswaran.meditationui.ui.theme.DeepBlue
import com.srivathsanvenkateswaran.meditationui.ui.theme.MeditationUITheme
import com.srivathsanvenkateswaran.meditationui.ui.theme.TextWhite

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        GreetingSection()


    }
}

@Composable
private fun GreetingSection(
    name: String = "Srivathsan"
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        GreetingSectionColumn(name = name)

        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            modifier = Modifier
                .size(24.dp),
            tint = Color.White
        )
    }
}

@Composable
private fun GreetingSectionColumn(
    name: String
) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Good Morning, $name",
            style = MaterialTheme.typography.h2,
            color = Color.White
        )

        Text(
            text = "We wish you have a good day!",
            style = MaterialTheme.typography.body1,
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MeditationUITheme {
        HomeScreen()
    }
}
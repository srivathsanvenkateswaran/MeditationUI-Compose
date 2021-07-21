package com.srivathsanvenkateswaran.meditationui.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.srivathsanvenkateswaran.meditationui.R
import com.srivathsanvenkateswaran.meditationui.ui.theme.*
import com.srivathsanvenkateswaran.meditationui.utils.DummyData
import com.srivathsanvenkateswaran.meditationui.utils.DummyData.chips
import com.srivathsanvenkateswaran.meditationui.utils.DummyData.name

@Composable
fun HomeScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = DeepBlue
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        
        Column() {
            GreetingSection()

            ChipSection()

            CurrentMeditation()
        }
    }
}

@Composable
private fun CurrentMeditation(
    backgroundColor: Color = LightRed
) {
    TextIconSection(
        iconResource = R.drawable.ic_play,
        iconTint = Color.White,
        headingText = "Daily Thought",
        subHeadingText = "Meditation • 3-10 min",
        rowModifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .padding(
                horizontal = 15.dp,
                vertical = 20.dp
            )
            .fillMaxWidth()
        ,
        iconModifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(ButtonBlue)
            .padding(10.dp),
        iconSize = 16.dp,
        subHeadingColor = TextWhite
    )
}

@Composable
private fun GreetingSection() {
    TextIconSection(
        iconResource = R.drawable.ic_search,
        iconTint = Color.White,
        headingText = "Good Morning, ${name}",
        subHeadingText = "We wish you have a good day!",
        rowModifier = Modifier
            .fillMaxWidth().
            padding(15.dp),
    )
}

@Composable
private fun ChipSection() {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow() {
        items(chips.size) {
            ChipItem(
                selectedChipIndex = selectedChipIndex,
                currentChipIndex = it
            )
        }
    }
}

@Composable
private fun ChipItem(
    selectedChipIndex: Int,
    currentChipIndex: Int
) {
    var selectedChipIndex1 = selectedChipIndex
    Box(
        modifier = Modifier
            .padding(
                start = 15.dp,
                top = 15.dp,
                bottom = 15.dp
            )
            .clickable {
                selectedChipIndex1 = currentChipIndex
            }
            .clip(RoundedCornerShape(10.dp))
            .background(
                if (currentChipIndex == selectedChipIndex1) {
                    ButtonBlue
                } else {
                    DarkerButtonBlue
                }
            )
            .padding(15.dp)
    ) {
        Text(
            text = chips[currentChipIndex],
            color = TextWhite,
            style = MaterialTheme.typography.h2
        )
    }
}

@Composable
private fun TextIconSection(
    iconResource: Int,
    iconTint: Color,
    headingText: String,
    subHeadingText: String,
    rowModifier: Modifier,
    iconModifier: Modifier = Modifier,
    iconSize: Dp = 24.dp,
    subHeadingColor: Color = AquaBlue
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = rowModifier
    ) {
        TextSectionColumn(
            headingText = headingText,
            subHeadingText = subHeadingText,
            subHeadingColor = subHeadingColor
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = iconModifier
        ) {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                modifier = Modifier
                    .size(iconSize),
                tint = iconTint
            )
        }
    }
}

@Composable
private fun TextSectionColumn(
    headingText: String,
    subHeadingText: String,
    subHeadingColor: Color
) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = headingText,
            style = MaterialTheme.typography.h2,
            color = Color.White
        )

        Text(
            text = subHeadingText,
            style = MaterialTheme.typography.body1,
            color = subHeadingColor
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
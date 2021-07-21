package com.srivathsanvenkateswaran.meditationui.ui.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.srivathsanvenkateswaran.meditationui.R
import com.srivathsanvenkateswaran.meditationui.ui.theme.*
import androidx.compose.foundation.Canvas
import androidx.compose.material.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.srivathsanvenkateswaran.meditationui.utils.DummyData.chips
import com.srivathsanvenkateswaran.meditationui.utils.DummyData.features
import com.srivathsanvenkateswaran.meditationui.utils.DummyData.name
import com.srivathsanvenkateswaran.meditationui.utils.Feature
import com.srivathsanvenkateswaran.meditationui.utils.standardQuadFromTo

@ExperimentalFoundationApi
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

            FeaturesSection(features)
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun FeaturesSection(
    features: List<Feature>
) {
    Text(
        text = "Features",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .padding(15.dp)
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
        modifier = Modifier
            .fillMaxHeight()
    ) {
        items(features) { feature ->
            FeatureItem(feature)
        }
    }
}

@Composable
private fun FeatureItem(
    feature: Feature
) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        // Medium colored path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {
            moveTo(
                x = mediumColoredPoint1.x,
                y = mediumColoredPoint1.y
            )
            standardQuadFromTo(mediumColoredPoint1, mediumColoredPoint2)
            standardQuadFromTo(mediumColoredPoint2, mediumColoredPoint3)
            standardQuadFromTo(mediumColoredPoint3, mediumColoredPoint4)
            standardQuadFromTo(mediumColoredPoint4, mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = feature.title,
                style = MaterialTheme.typography.h2,
                fontSize = 22.sp,
                modifier = Modifier
                    .align(Alignment.TopStart),
                letterSpacing = 1.sp
            )

            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )

            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = ButtonBlue
                )
            ) {
                Text(
                    text = "Start",
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
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
            .fillMaxWidth()
            .padding(15.dp),
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

@ExperimentalFoundationApi
@Preview
@Composable
fun HomeScreenPreview() {
    MeditationUITheme {
        HomeScreen()
    }
}
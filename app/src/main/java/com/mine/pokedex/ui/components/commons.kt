package com.mine.pokedex.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LoadingScreen() {
    Text("Loading")
}

@Composable
fun ErrorScreen() {
    Text("Error")
}

@Composable
fun PokemonStatsProgressBar(
    indicatorProgress: Float = 0.5f,
    statLable: String,
    statRation: Float = 0f,
    statRationLabel: String = "",
    color: Color = ProgressIndicatorDefaults.linearTrackColor
) {
    Row(
        modifier = Modifier.padding(horizontal = 25.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        var progressCount: Int by remember { mutableStateOf(0) }
        var progress by remember { mutableStateOf(0f) }


        when (progressCount) {
            0 -> progress = 0.0f
            1 -> progress = 0.1f
            2 -> progress = 0.2f
            3 -> progress = 0.3f
            4 -> progress = 0.4f
            5 -> progress = 0.5f
            6 -> progress = 0.6f
            7 -> progress = indicatorProgress
            8 -> progress = 0.8f
            9 -> progress = 0.9f
            10 -> progress = 1.0f
        }

        val size by animateFloatAsState(
            targetValue = progress,
            tween(
                durationMillis = 1000,
                delayMillis = 200,
                easing = LinearOutSlowInEasing
            )
        )


        Text(
            modifier = Modifier.width(40.dp),
            text = statLable.uppercase(),
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center
        ) {

            // Progress Bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(18.dp)
                    .clip(MaterialTheme.shapes.large),
                contentAlignment = Alignment.CenterStart
            ) {
                // for the background of the ProgressBar
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surface)

                )
                // for the progress of the ProgressBar
                Box(
                    modifier = Modifier
                        .fillMaxWidth(size)
                        .fillMaxHeight()
                        .clip(MaterialTheme.shapes.large)
                        .background(color)
                        .animateContentSize()
                )
                Text(
                    text = statRationLabel,
                    modifier = Modifier
                        .offset(y = -2.dp)
                        .padding(end = 15.dp)
                        .fillMaxWidth(size)
                        .height(20.dp)
                        .animateContentSize(),
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.SemiBold
                )
            }


        }

//    Use this when you want your progress bar should animate when you open your app
        LaunchedEffect(key1 = true) {
            progressCount = 7
        }

    }
}
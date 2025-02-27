package com.swapnil.bubbleanimation

import androidx.compose.ui.graphics.Color

data class OnBoardingData(
    val animation: Int,  // Change from image to animation
    val title: String,
    val desc: String,
    val backgroundColor: Color,
    val mainColor: Color = Color.Blue,
)

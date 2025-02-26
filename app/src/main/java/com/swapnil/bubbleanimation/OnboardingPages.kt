package com.swapnil.bubbleanimation

import androidx.compose.ui.graphics.Color

val onboardingItems = listOf(
    OnBoardingData(
        animation = R.raw.crypto1, // Replace with your Lottie JSON file
        title = "Welcome to CryptoX",
        desc = "Buy and sell cryptocurrency using virtual money at live market prices.",
        backgroundColor = Color(0xFF292D32),
        mainColor = Color(0xFF23AF92)
    ),
    OnBoardingData(
        animation = R.raw.crypto2, // Replace with another Lottie animation
        title = "Trade Easily",
        desc = "Simulate real-world trading with virtual currency and live rates.",
        backgroundColor = Color(0xFFF2F5F8),
        mainColor = Color(0xFF36C0A3)
    ),
    OnBoardingData(
        animation = R.raw.crypto3, // Replace with another Lottie animation
        title = "Secure & Fun",
        desc = "Experience the crypto market without real-world risks.",
        backgroundColor = Color(0xFF292D32),
        mainColor = Color(0xFF3BC5A8)
    )
)
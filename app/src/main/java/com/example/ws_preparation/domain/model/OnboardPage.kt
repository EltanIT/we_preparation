package com.example.ws_preparation.domain.model

import androidx.annotation.DrawableRes
import com.example.ws_preparation.R


// Класс для работы с Onboard
// Мичкасов Георгий
// 28.02.2024 11.00
data class OnboardPage(
    val title: String = "",
    val description: String = "",
    @DrawableRes val image: Int = 0,
)

val onboardPageQueueDefault = listOf<OnboardPage>(
    OnboardPage(
        title = "Quick Delivery At Your Doorstep",
        description = "Enjoy quick pick-up and delivery to your destination",
        image = R.drawable.ic_onboard1,
    ),
    OnboardPage(
        title = "Flexible Payment",
        description = "Different modes of payment either before and after delivery without stress",
        image = R.drawable.ic_onboard2,
    ),
    OnboardPage(
        title = "Real-time Tracking",
        description = "Track your packages/items from the comfort of your home till final destination",
        image = R.drawable.ic_onboard3,
    ),
)
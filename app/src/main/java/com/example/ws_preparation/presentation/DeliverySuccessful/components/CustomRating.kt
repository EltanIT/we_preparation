package com.example.ws_preparation.presentation.DeliverySuccessful.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.ui.theme.Gray2


@Composable
fun CustomRating(
    countStars: Int = 5,
    countActiveStars: Int,
) {

    val countInactiveStars = countStars-countActiveStars

    Row() {
        repeat(countActiveStars){
            Icon(painter = painterResource(id = R.drawable.ic_star_inactive), contentDescription = null,
            tint = Color.Yellow)
            if (it!=countStars){
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
        repeat(countInactiveStars){
            Icon(painter = painterResource(id = R.drawable.ic_star_inactive), contentDescription = null,
                tint = Gray2)
            if (it!=countStars){
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}
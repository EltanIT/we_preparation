package com.example.ws_preparation.presentation.Onboard.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun CenterPart(
    title: String,
    description: String
) {
    Column(Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title,
        style = TextStyle(
            fontSize =24.sp,
            lineHeight = 24.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(700),
            textAlign = TextAlign.Center,
            color = PrimaryColor
        )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = description,
            style = TextStyle(
                fontSize =16.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                textAlign = TextAlign.Center,
                color = Text4
            )
        )
    }
}
package com.example.ws_preparation.presentation.SignUp.components

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun SignUpScreen(

) {

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())) {
        Text(text = "Create an account",
        style = TextStyle(
            fontSize =24.sp,
            lineHeight = 30.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(500),
            color = Color.White
        )
        )
        
    }
}
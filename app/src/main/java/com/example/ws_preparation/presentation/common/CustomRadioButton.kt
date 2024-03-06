package com.example.ws_preparation.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor


@Composable
fun CustomRadioButton(
    isSelected: Boolean
) {

    Box(Modifier.size(12.dp).clip(CircleShape).background(Color.White).border(1.dp, PrimaryColor, CircleShape), contentAlignment = Alignment.Center){
        Box(Modifier.size(9.dp).clip(CircleShape).background(if (isSelected) PrimaryColor else Color.White))
    }
}
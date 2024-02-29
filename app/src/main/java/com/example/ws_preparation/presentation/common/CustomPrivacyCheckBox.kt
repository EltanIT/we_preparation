package com.example.ws_preparation.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor


@Composable
fun CustomPrivacyCheckBox(
    isChecked: Boolean,
    onCheckedListener: () -> Unit
    
) {
    
    Box(
        modifier = Modifier
            .size(14.dp)
            .border(1.dp, PrimaryColor, RoundedCornerShape(2.dp))
            .clip(RoundedCornerShape(2.dp))
            .background(if (isChecked) PrimaryColor else Color.White)
            .clickable { onCheckedListener() },
    contentAlignment = Alignment.Center) {
        if (isChecked){
            Image(painter = painterResource(id = R.drawable.ic_checkbox_vector),
                contentScale = ContentScale.Crop,
                contentDescription = null)
        }
    }
}
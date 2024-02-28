package com.example.ws_preparation.presentation.Onboard.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import coil.compose.rememberAsyncImagePainter


@Composable
fun TopPart(
    @DrawableRes image: Int
) {
    if (image!=0){
        Image(painter = rememberAsyncImagePainter(model = image), contentDescription = null)
    }
}
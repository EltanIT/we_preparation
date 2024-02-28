package com.example.ws_preparation.presentation.Onboard.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberAsyncImagePainter


@Composable
fun TopPart(
    @DrawableRes image: Int,
    modifier: Modifier
) {
    if (image!=0){
        Image(painter = rememberAsyncImagePainter(model = image),
            contentDescription = null,
            modifier = modifier)
    }
}
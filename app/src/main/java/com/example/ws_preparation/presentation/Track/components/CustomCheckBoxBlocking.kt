package com.example.ws_preparation.presentation.Track.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun CustomCheckBoxBlocking(
    isChecked: Boolean,
) {


    Box(
        modifier = Modifier
            .size(14.dp)
            .border(if (isChecked) 1.dp else 0.dp, PrimaryColor, RoundedCornerShape(2.dp))
            .clip(RoundedCornerShape(2.dp))
            .background(if (isChecked) PrimaryColor else Color(0xffE0E0E0)),
        contentAlignment = Alignment.Center) {
        if (isChecked){
            Image(painter = painterResource(id = R.drawable.ic_checkbox_vector),
                contentScale = ContentScale.Crop,
                contentDescription = null)
        }else{
            Spacer(modifier = Modifier
                .width(8.17.dp)
                .height(1.dp)
                .background(Color.White))
        }
    }
}
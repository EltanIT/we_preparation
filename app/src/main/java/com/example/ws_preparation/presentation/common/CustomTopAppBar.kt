package com.example.ws_preparation.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun CustomTopAppBar(
title: String,
isBackStack: Boolean,
onBackClickListener: () -> Unit
) {

    Card(modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = RoundedCornerShape(0.dp)) {
        Box(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 15.dp, start=15.dp, end = 15.dp)) {
                if (isBackStack){
                    Image(painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .clickable { onBackClickListener() })
                }
            Text(text = title,
                modifier = Modifier.align(Alignment.Center),
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = Gray2
            ))

        }
    }



}
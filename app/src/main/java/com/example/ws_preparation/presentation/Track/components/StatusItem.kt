package com.example.ws_preparation.presentation.Track.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.common.CustomPrivacyCheckBox
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun StatusItem(
    isTrue: Boolean,
    isActive: Boolean,
    isLast: Boolean,
    title: String,
    date: String
) {

    Row {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if (isLast){
                CustomCheckBoxBlocking(isChecked = isTrue)
            }else{
                CustomPrivacyCheckBox(isChecked = isTrue) {}
            }
            if (!isLast){
                Spacer(modifier = Modifier
                    .width(1.dp)
                    .height(34.dp)
                    .background(Gray2))
            }
        }
        Spacer(modifier = Modifier.width(7.dp))
        Column() {
            Text(text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Roboto),
                    color = if (isActive) PrimaryColor else Gray2
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = date,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Roboto),
                    color = Color(0xffEC8000)
                )
            )
        }


    }
}
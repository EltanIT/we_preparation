package com.example.ws_preparation.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.domain.model.ChargesPackageData
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun ChargesInformation(
    chargesPackageData: ChargesPackageData
) {

    Text(text = "Charges",
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(500),
            color = PrimaryColor
        )
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Package Items",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Text(text = chargesPackageData.deliveryCharges?:"",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Color(0xffEC8000)
            )
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Instant delivery",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Text(text = chargesPackageData.instantDelivery?:"",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Color(0xffEC8000)
            )
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Tax and Service Charges",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Text(text = chargesPackageData.taxCharges?:"",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Color(0xffEC8000)
            )
        )
    }
    Spacer(modifier = Modifier.height(9.dp))
    Spacer(modifier = Modifier
        .height(1.dp)
        .fillMaxWidth()
        .background(Gray2))
    Spacer(modifier = Modifier.height(4.dp))
    Row(Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Package total",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Text(text = chargesPackageData.packageTotal?:"",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Color(0xffEC8000)
            )
        )
    }

}
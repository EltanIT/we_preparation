package com.example.ws_preparation.presentation.SendAPackageReceipt.components

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
import com.example.ws_preparation.domain.model.OriginDestinationDetails
import com.example.ws_preparation.domain.model.PackageDetails
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun PackageInformation(
    address: String,
    number: String,

    destinationDetails: List<OriginDestinationDetails>,
    packageDetails: PackageDetails,
    uuid: String
) {
    Text(text = "Package Information",
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(500),
            color = PrimaryColor
        )
        )
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Origin details",
        style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(400),
            color = Text4
        )
    )


    Spacer(modifier = Modifier.height(4.dp))
    Text(text = address,
        style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(400),
            color = Gray2
        )
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = "+${number}",
        style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(400),
            color = Gray2
        )
    )

    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Destination details",
        style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(400),
            color = Text4
        )
    )



    repeat(destinationDetails.size){
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "${it+1}${destinationDetails[it].address}, ${destinationDetails[it].state}",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )

        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "+${destinationDetails[it].phoneNumber}",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
    }


    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "Other details",
        style = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(400),
            color = Text4
        )
    )
    Spacer(modifier = Modifier.height(4.dp))
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
        Text(text = packageDetails.packageItems?:"",
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
        Text(text = "Weight of items",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Text(text = packageDetails.weightItem?:"",
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
        Text(text = "Worth of Items",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Text(text = packageDetails.worthItems?:"",
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
        Text(text = "Tracking Number",
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Text(text = uuid,
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Color(0xffEC8000)
            )
        )
    }
    Spacer(modifier = Modifier.height(37.dp))
    Spacer(modifier = Modifier
        .height(1.dp)
        .fillMaxWidth()
        .background(Gray2))



}
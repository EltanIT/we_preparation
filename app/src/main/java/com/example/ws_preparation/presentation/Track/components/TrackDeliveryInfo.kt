package com.example.ws_preparation.presentation.Track.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.ws_preparation.domain.model.DeliveryData
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun TrackDeliveryInfo(
    uuid: String,
    deliveryData: DeliveryData,
    onButtonClickListener: () -> Unit
) {

    val titleList = listOf(
        "Courier requested",
        "Package ready for delivery",
        "Package in transit",
        "Package delivered",
    )

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(42.dp))
        Text(text = "Tracking Number",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(500),
                fontFamily = FontFamily(Roboto),
                color = Text4
            )
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.ic_uuid), contentDescription =null )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = uuid,
                maxLines = 1,
                style = TextStyle(
                    fontSize = 15.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    fontFamily = FontFamily(Roboto),
                    color = PrimaryColor
                )
            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Package Status",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Roboto),
                color = Gray2
            )
        )
        Spacer(modifier = Modifier.height(24.dp))

        repeat(4){
            StatusItem(
                isTrue = it<=deliveryData.status,
                isLast = it==3,
                title = titleList[it],
                date = deliveryData.date?:"")
        }
        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {onButtonClickListener()},
            modifier = Modifier
                .fillMaxWidth()
                .height(46.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryColor
        ),
        shape = RoundedCornerShape(8.dp)) {
            Text(text = "View Package Info",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(700),
                    fontFamily = FontFamily(Roboto),
                    color = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(40.dp))



    }



}
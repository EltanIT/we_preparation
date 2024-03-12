package com.example.ws_preparation.presentation.Home.components

import android.content.DialogInterface.OnClickListener
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Gray6
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun ActionHomeItem(
    modifier: Modifier,
    image: Int,
    title: String,
    description: String,
    onClickListener: () -> Unit
) {

    Card(modifier.clickable { onClickListener() }.height(156.dp),
    shape = RoundedCornerShape(8.dp),
    elevation = CardDefaults.cardElevation(
        2.dp
    ),
    colors = CardDefaults.cardColors(
        containerColor = Gray6
    )) {
        Column(Modifier.padding(start = 8.dp, top = 26.5.dp)) {
            Icon(painter = painterResource(id = image), contentDescription = null,
            tint = PrimaryColor)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(500),
                    color = PrimaryColor
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = description,
                modifier = Modifier.padding(end = 24.dp),
                style = TextStyle(
                    fontSize = 7.45.sp,
                    lineHeight = 9.94.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(400),
                    color = Text4
                )
            )
        }
    }
}
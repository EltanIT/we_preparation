package com.example.ws_preparation.presentation.Home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.HiltTextColor
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun HomeProfileRow(
    name: String,
    image: Any,
    notificationClickListener: () -> Unit

) {

    Box(modifier = Modifier.fillMaxWidth()
        .background(PrimaryColor, RoundedCornerShape(8.dp))
        .clip(RoundedCornerShape(8.dp))){
        Image(
            painter = painterResource(id = R.drawable.ic_ellipse_top),
            contentDescription = null,
        modifier = Modifier.align(Alignment.TopEnd))
        Image(
            painter = painterResource(id = R.drawable.ic_ellipse_bottom),
            contentDescription = null,
            modifier = Modifier.align(Alignment.BottomStart))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 15.43.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(painter = rememberAsyncImagePainter(model = image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.14.dp)
                    .clip(CircleShape)
                    .background(Gray2))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = " Hello $name!",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 30.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(500),
                        color = Color.White
                    )
                )
                Text(text = "  We trust you are having a great time",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(400),
                        color = HiltTextColor
                    )
                )
            }
            Image(painter = painterResource(id = R.drawable.ic_notification), contentDescription = null,
                modifier = Modifier.clickable {
                    notificationClickListener()
                })


        }
    }


}
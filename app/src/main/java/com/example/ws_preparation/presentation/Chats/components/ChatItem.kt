package com.example.ws_preparation.presentation.Chats.components

import android.widget.AdapterView.OnItemClickListener
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun ChatItem(
    name: String,
    lastMessage: String,
    countMessage: Int,
    image: Any,
    onItemClickListener: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemClickListener() }
        .border(1.dp, Gray2, RoundedCornerShape(10.dp)),
    shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(
            0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) { 
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.03.dp),
        verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = rememberAsyncImagePainter(model = image),
                contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .size(60.14.dp),
            contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.width(12.03.dp))
            Column(Modifier.weight(1f)) {
                Text(text = name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(500),
                        color = Text4
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = lastMessage,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(400),
                        color = Text4
                    )
                )
            }
            if (countMessage>0){
                Box(
                    Modifier
                        .size(26.dp)
                        .clip(CircleShape)
                        .background(PrimaryColor, CircleShape),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = countMessage.toString(),
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Roboto),
                            fontWeight = FontWeight(400),
                            color = Color.White
                        )
                    )
                }
            }

        }
    }   
}
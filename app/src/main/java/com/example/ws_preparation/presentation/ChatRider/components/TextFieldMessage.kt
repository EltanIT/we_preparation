package com.example.ws_preparation.presentation.ChatRider.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Gray6
import com.example.ws_preparation.presentation.ui.theme.HiltTextColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun TextFieldMessage(
    value: String,
    modifier: Modifier,
    hiltText: String,
    onChangedListener: (String) -> Unit
) {

    BasicTextField(
        value = value,
        onValueChange = {onChangedListener(it)},
        modifier = modifier
            .height(40.dp)
            .border(1.dp, HiltTextColor, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp))
            .background(if(value.isEmpty()) HiltTextColor else Color.White, RoundedCornerShape(8.dp)),
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(400),
            color = Color.Black
        ),
        decorationBox = {
            Row(Modifier.fillMaxSize().padding(start=32.dp, end=12.93.dp),
            verticalAlignment = Alignment.CenterVertically) {
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(end=12.dp)
                        .weight(1f),
                    contentAlignment = Alignment.CenterStart) {
                    if (value.isEmpty()){
                        Text(text = hiltText,
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 16.sp,
                                fontFamily = FontFamily(Roboto),
                                fontWeight = FontWeight(400),
                                color = Gray2
                            )
                        )
                    }
                    it()
                }
                Image(painter = painterResource(id = R.drawable.ic_micro), contentDescription = null)
            }


        })
}
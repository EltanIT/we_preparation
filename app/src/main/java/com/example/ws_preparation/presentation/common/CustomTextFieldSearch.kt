package com.example.ws_preparation.presentation.common

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
import com.example.ws_preparation.presentation.ui.theme.HiltTextColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun CustomTextFieldSearch(
    value: String,
    hiltText: String,
    onChangedListener: (String) -> Unit
) {

    BasicTextField(
        value = value,
        onValueChange = {onChangedListener(it)},
        modifier = Modifier
            .height(34.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(HiltTextColor),
        textStyle = TextStyle(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(400),
            color = Text4
        ),
    decorationBox = {
        Row(Modifier.fillMaxSize()) {
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.CenterStart) {
                if (value.isEmpty()){
                    Text(text = hiltText,
                        style = TextStyle(
                            fontSize = 12.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Roboto),
                            fontWeight = FontWeight(400),
                            color = Gray2
                        ))
                }
                it()
            }
            Image(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
        }


    })

}
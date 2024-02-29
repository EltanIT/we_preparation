package com.example.ws_preparation.presentation.OTPVerification.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
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
import com.example.ws_preparation.presentation.ui.theme.ErrorColor
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun CustomOTPTextField(
    countItem: Int = 6,
    code: String,
    isError: Boolean,
    onChangedCode: (String) -> Unit
) {
    BasicTextField(value = code, onValueChange = {onChangedCode(it)},
    decorationBox = {
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {
            repeat(countItem){
                otpItem(
                    char = when{
                               it == code.length -> ""
                                it >code.length -> ""
                        else -> code[it].toString()
                               },
                    isError = isError)
            }
        }
    })



}


@Composable
fun otpItem(
    char: String,
    isError: Boolean
){
    Box(
        Modifier
            .size(32.dp)
            .border(
                1.dp,
                if (isError) ErrorColor else if (!isError && !char.equals("")) PrimaryColor else Gray2
            )
            .background(Color.White),
    contentAlignment = Alignment.Center) {
        Text(text = char,
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(400),
            color = Color.Black
        )
        )
    }

}
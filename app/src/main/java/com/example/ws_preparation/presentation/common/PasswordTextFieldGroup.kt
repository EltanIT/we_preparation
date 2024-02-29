package com.example.ws_preparation.presentation.common

import androidx.compose.foundation.layout.Column
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
import com.example.ws_preparation.presentation.common.CustomPasswordTextFieldAuthorization
import com.example.ws_preparation.presentation.common.CustomTextFieldAuthorization
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun PasswordTextFieldGroup(
    title: String,
    value: String,
    hiltText: String,
    onChangedListener: (String) -> Unit
) {
    
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = Gray2
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomPasswordTextFieldAuthorization(
            value = value,
            hiltText = hiltText,
            onChangedListener = {onChangedListener(it)})
    }
    
}
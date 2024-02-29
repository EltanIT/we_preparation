package com.example.ws_preparation.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun CustomAuthorizationButton(
    text: String,
    stateButton: Boolean,
    onClickedListener: () -> Unit
) {
    Button(onClick = {onClickedListener()},
    modifier = Modifier
    .fillMaxWidth()
    .height(46.dp),
        shape = RoundedCornerShape(4.dp),
    colors = ButtonDefaults.buttonColors(
    containerColor = if (stateButton) PrimaryColor else Gray2
    )) {
        Text(text = text,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 16.sp,
                fontWeight = FontWeight(700),
                fontFamily = FontFamily(Roboto),
                color = Color.White,
            )
        )
    }
}
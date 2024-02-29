package com.example.ws_preparation.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.HiltTextColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun CustomPasswordTextFieldAuthorization(
    value: String,
    hiltText: String,
    onChangedListener: (String) -> Unit
) {

    var isVisible by remember {
        mutableStateOf(false)
    }

    BasicTextField(
        value = value,
        onValueChange = {onChangedListener(it)},
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .border(1.dp, Gray2, RoundedCornerShape(4.dp)),
        visualTransformation = if (!isVisible) PasswordVisualTransformation('*') else VisualTransformation.None,
        textStyle = TextStyle(
            fontSize = 14.sp,
            lineHeight = 16.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(500),
            color = Text4
        ),
    decorationBox = {
        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f),
                contentAlignment = Alignment.CenterStart) {
                if (value.isEmpty()){
                    Text(text = hiltText,
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 16.sp,
                            fontFamily = FontFamily(Roboto),
                            fontWeight = FontWeight(500),
                            color = HiltTextColor
                        ))
                }
                it()
            }
            Image(painter = painterResource(id = R.drawable.ic_eye_slash),
                modifier = Modifier.clickable { isVisible = !isVisible },
                contentDescription = null)
            
        }


    })

}
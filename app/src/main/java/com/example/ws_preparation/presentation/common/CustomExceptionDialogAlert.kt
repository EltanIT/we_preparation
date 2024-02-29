package com.example.ws_preparation.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@ExperimentalMaterial3Api
@Composable
fun CustomExceptionDialogAlert(
    exception: String,
    onCloseDialog: () -> Unit
) {
    
    AlertDialog(onDismissRequest = {onCloseDialog},
        modifier = Modifier.padding(24.dp)
    ) {
        Column(
            Modifier
                .background(Color.White)
                .fillMaxWidth()) {
            Text(text = "Ошибка",
                style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = Text4
            ))
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = exception,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(400),
                    color = Gray2
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = {onCloseDialog()},
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor
            )) {
                Text(text = "Ок",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 15.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(500),
                        color = Color.White
                    ))
            }
        }
    }
}
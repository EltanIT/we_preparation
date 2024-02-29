package com.example.ws_preparation.presentation.SignIn.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.common.CustomPrivacyCheckBox
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun PasswordActionsRow(
    isRemember: Boolean,
    onForgotClickListener: () -> Unit,
    onCheckedChangeListener: () -> Unit,
) {
    
    Row(Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically) {
        CustomPrivacyCheckBox(isChecked = isRemember) {
            onCheckedChangeListener()
        }
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "Remember password",
            modifier = Modifier
                .weight(1f),
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = Gray2,
                textAlign = TextAlign.Start
            )
        )
        Text(text = "Forgot Password?",
            modifier = Modifier
                .clickable { onForgotClickListener() },
            style = TextStyle(
                fontSize = 12.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = PrimaryColor,
                textAlign = TextAlign.End
            )
        )
    }
}
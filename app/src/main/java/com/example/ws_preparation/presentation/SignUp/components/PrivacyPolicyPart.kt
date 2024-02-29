package com.example.ws_preparation.presentation.SignUp.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.presentation.common.CustomPrivacyCheckBox
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.WarningColor


@Composable
fun PrivacyPolicyPart(
    isChecked: Boolean,
    onLinkClickListener: () -> Unit,
    onCheckedListener: () -> Unit
) {

    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Roboto),
                color = Gray2,
            )
        ){
            append("By ticking this box, you agree to our ")
        }
        pushStringAnnotation("click", "click")
        withStyle(
            style = SpanStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                fontFamily = FontFamily(Roboto),
                color = WarningColor
            )
        ){
            append("Terms and \nconditions and private policy")
        }
    }

    Row(Modifier.fillMaxWidth()){
        CustomPrivacyCheckBox(isChecked = isChecked) {
            onCheckedListener()
        }
        Spacer(modifier = Modifier.width(22.dp))
        ClickableText(text = text, onClick = {
            text.getStringAnnotations(tag="click", start = it, end = it).firstOrNull()
                ?.let {
                    onLinkClickListener()
                }
            },
            style = TextStyle(
                lineHeight = 16.sp,
                textAlign = TextAlign.Center
            ))


    }
}
package com.example.ws_preparation.presentation.SignUp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ws_preparation.R
import com.example.ws_preparation.presentation.common.CustomAuthorizationButton
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.PrimaryColor
import com.example.ws_preparation.presentation.ui.theme.Roboto


@Composable
fun BottomPart(
    text: String,
    buttonState: Boolean,
    onButtonClickListener: () -> Unit,
    onSignInClickListener: () -> Unit,
    onGoogleClickListener: () -> Unit,

) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
       CustomAuthorizationButton(text = text, buttonState) {
            onButtonClickListener()
       }
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Text(text = "Already have an account?",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(400),
                    color = Gray2
                )
            )
            Text(text = "Sign in",
                modifier = Modifier.clickable { onSignInClickListener() },
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(500),
                    color = PrimaryColor
                )
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "or sign in using",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(400),
                color = Gray2
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(painter = painterResource(id = R.drawable.ic_google), contentDescription = null,
        modifier = Modifier.clickable { onGoogleClickListener() })
    }

}
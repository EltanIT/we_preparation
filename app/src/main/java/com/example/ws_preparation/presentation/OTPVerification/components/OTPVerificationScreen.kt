package com.example.ws_preparation.presentation.OTPVerification.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_preparation.presentation.OTPVerification.OTPVerificationViewModel
import com.example.ws_preparation.presentation.common.CustomAuthorizationButton
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun OTPVerificationScreen(
    viewModel: OTPVerificationViewModel,
    navController: NavController
) {

    val code by remember{
        derivedStateOf {
            mutableStateOf(viewModel.code)
        }
    }
    val isError by remember{
        derivedStateOf {
            mutableStateOf(viewModel.isError)
        }
    }

    val stateButton by remember{
        derivedStateOf {
            mutableStateOf(viewModel.stateButton)
        }
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp,)
            .background(Color.White)) {
        Spacer(modifier = Modifier.height(110.dp))
        Text(text = "OTP Verification",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 30.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = Text4
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Enter the 6 digit numbers sent to your email",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = Gray2
            )
        )
        Spacer(modifier = Modifier.height(70.dp))
        CustomOTPTextField(code = code.value, isError = isError.value, onChangedCode = {
            viewModel.redactCode(it)
        })


        Spacer(modifier = Modifier.height(30.dp))
        Row(Modifier.fillMaxWidth()) {
            Text(text = "If you didn’t receive code, ",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(400),
                    color = Gray2
                )
            )
            Text(text = "resend after 1:00",
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Roboto),
                    fontWeight = FontWeight(500),
                    color = Gray2
                )
            )
        }
        Spacer(modifier = Modifier.height(82.dp))
        CustomAuthorizationButton(text = "Set New Password", stateButton.value) {
            navController.navigate(Route.NewPasswordScreen.route)
        }


    }
}
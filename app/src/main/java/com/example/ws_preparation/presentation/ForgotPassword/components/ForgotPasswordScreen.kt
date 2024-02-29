package com.example.ws_preparation.presentation.ForgotPassword.components

import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ws_preparation.presentation.ForgotPassword.ForgotPasswordViewModel
import com.example.ws_preparation.presentation.common.TextFieldGroup
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@Composable
fun ForgotPasswordScreen(
    viewModel: ForgotPasswordViewModel,
    navController: NavController
) {

    val email by remember{
        derivedStateOf {
            mutableStateOf(viewModel.email)
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
            .padding(start = 24.dp, end = 24.dp, top = 110.dp)) {
        Text(text = "Forgot Password",
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
        Text(text = "Enter your email address",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = Gray2
            )
        )
        Spacer(modifier = Modifier.height(56.dp))
        TextFieldGroup(title = "Email Address", value = email.value, hiltText = "***********@mail.com", onChangedListener = {
            viewModel.redactEmail(it)
        })
        Spacer(modifier = Modifier.height(56.dp))
        BottomPart(text = "Send OTP",
            stateButton = stateButton.value,
            onButtonClickListener = {
            navController.navigate(Route.OTPVerificationScreen.route.replace("{email}", email.value))
        }) {
            navController.popBackStack()
            
        }
    }
}
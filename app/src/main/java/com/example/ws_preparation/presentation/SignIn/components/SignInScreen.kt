package com.example.ws_preparation.presentation.SignIn.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
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
import com.example.ws_preparation.presentation.SignIn.SignInViewModel
import com.example.ws_preparation.presentation.common.CustomExceptionDialogAlert
import com.example.ws_preparation.presentation.common.PasswordTextFieldGroup
import com.example.ws_preparation.presentation.common.TextFieldGroup
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@ExperimentalMaterial3Api
@Composable
fun SignInScreen(
    viewModel: SignInViewModel,
    navController: NavController
) {

    val data by remember{
        derivedStateOf {
            mutableStateOf(viewModel.data)
        }
    }

    val buttonState by remember{
        derivedStateOf {
            mutableStateOf(viewModel.buttonState)
        }
    }

    val exception by remember{
        derivedStateOf {
            mutableStateOf(viewModel.exception)
        }
    }

    if (exception.value.isNotEmpty()){
        if (exception.value == "true"){
                navController.navigate(Route.HomeScreen.route)
        }else{
            CustomExceptionDialogAlert(exception = exception.value) {
                viewModel.closeException()
            }
        }
    }


    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp, top = 110.dp)) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)) {
                Text(text = "Welcome Back",
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
                Text(text = "Fill in your email and password to continue",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontFamily = FontFamily(Roboto),
                        fontWeight = FontWeight(500),
                        color = Gray2
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                
                TextFieldGroup(title = "Email Address",
                    value = data.value.email,
                    hiltText = "***********@mail.com",
                    onChangedListener = {
                    viewModel.redactEmail(it)
                })
                Spacer(modifier = Modifier.height(24.dp))
                PasswordTextFieldGroup(title = "Password", value =
                data.value.password,
                    hiltText = "**********",
                    onChangedListener = {
                        viewModel.redactPassword(it)
                    })

                Spacer(modifier = Modifier.height(17.dp))

                PasswordActionsRow(isRemember = data.value.rememberPas, onForgotClickListener = {
                    navController.navigate(Route.ForgotPasswordScreen.route)
                }) {
                    viewModel.redactRememberPassword()
                }
            }
        BottomPart(
            text = "Log in",
            buttonState = buttonState.value,
            onButtonClickListener = { viewModel.signIn() },
            onSignUpClickListener = { navController.navigate(
                Route.SignUpScreen.route)
            }) {
        }
        Spacer(modifier = Modifier.height(95.dp))
    }
}
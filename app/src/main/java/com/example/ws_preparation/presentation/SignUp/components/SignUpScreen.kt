package com.example.ws_preparation.presentation.SignUp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.ws_preparation.presentation.SignUp.SignUpViewModel
import com.example.ws_preparation.presentation.common.CustomExceptionDialogAlert
import com.example.ws_preparation.presentation.common.PasswordTextFieldGroup
import com.example.ws_preparation.presentation.common.TextFieldGroup
import com.example.ws_preparation.presentation.navgraph.Route
import com.example.ws_preparation.presentation.ui.theme.Gray2
import com.example.ws_preparation.presentation.ui.theme.Roboto
import com.example.ws_preparation.presentation.ui.theme.Text4


@ExperimentalMaterial3Api
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
    navController: NavController
) {


    val profile by remember{
        derivedStateOf {
            mutableStateOf(viewModel.profile)
        }
    }

    val exception by remember{
        derivedStateOf {
            mutableStateOf(viewModel.exception)
        }
    }

    val privacyCheck by remember{
        derivedStateOf {
            mutableStateOf(viewModel.privacyCheck)
        }
    }

    val confirmPassword by remember{
        derivedStateOf {
            mutableStateOf(viewModel.confirmPassword)
        }
    }

    val buttonState by remember{
        derivedStateOf {
            mutableStateOf(viewModel.buttonState)
        }
    }

    if (exception.value.isNotEmpty()){
        if (exception.value.equals("true")){
            navController.navigate(Route.SignInScreen.route)
        }else{
            CustomExceptionDialogAlert(exception = exception.value) {
                viewModel.closeException()
            }
        }

    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
            .verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(36.dp))
        Text(text = "Create an account",
            modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 24.sp,
            lineHeight = 30.sp,
            fontFamily = FontFamily(Roboto),
            fontWeight = FontWeight(500),
            color = Text4
        ))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Complete the sign up process to get started",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 16.sp,
                fontFamily = FontFamily(Roboto),
                fontWeight = FontWeight(500),
                color = Gray2
            )
        )
        Spacer(modifier = Modifier.height(33.dp))


        TextFieldGroup(
            title = "Full name",
            value = profile.value.fullName,
            hiltText = "Ivanov Ivan",
            onChangedListener = {viewModel.redactFullName(it)})
        Spacer(modifier = Modifier.height(24.dp))
        TextFieldGroup(
            title = "Phone Number",
            value = profile.value.phoneNumber,
            hiltText = "+7(999)999-99-99",
            onChangedListener = {viewModel.redactPhoneNumber(it)})
        Spacer(modifier = Modifier.height(24.dp))
        TextFieldGroup(
            title = "Email Address",
            value = profile.value.email,
            hiltText = "***********@mail.com",
            onChangedListener = {viewModel.redactEmail(it)})
        Spacer(modifier = Modifier.height(24.dp))
        PasswordTextFieldGroup(
            title = "Password",
            value = profile.value.password,
            hiltText = "**********",
            onChangedListener = {viewModel.redactPassword(it)})
        Spacer(modifier = Modifier.height(24.dp))
        PasswordTextFieldGroup(
            title = "Confirm Password",
            value = confirmPassword.value,
            hiltText = "**********",
            onChangedListener = {viewModel.redactConfirmPassword(it)})
        Spacer(modifier = Modifier.height(37.dp))


        PrivacyPolicyPart(isChecked = privacyCheck.value, onLinkClickListener = {

        }) {
            viewModel.redactPrivacyCheck()
        }

        Spacer(modifier = Modifier.height(64.dp))

        BottomPart(
            text = "Sign Up",
            buttonState = buttonState.value,
            onButtonClickListener = {
                if (buttonState.value){
                    viewModel.signUp()
                }},
            onSignInClickListener = { navController.navigate(Route.SignInScreen.route)  }) {
            viewModel.signInWithGoogle()
        }
        Spacer(modifier = Modifier.height(28.dp))
        
    }
}
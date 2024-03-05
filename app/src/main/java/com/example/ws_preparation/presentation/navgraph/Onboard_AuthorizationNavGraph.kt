package com.example.ws_preparation.presentation.navgraph

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ws_preparation.presentation.ForgotPassword.ForgotPasswordViewModel
import com.example.ws_preparation.presentation.ForgotPassword.components.ForgotPasswordScreen
import com.example.ws_preparation.presentation.Home.HomeScreen
import com.example.ws_preparation.presentation.OTPVerification.OTPVerificationViewModel
import com.example.ws_preparation.presentation.OTPVerification.components.OTPVerificationScreen
import com.example.ws_preparation.presentation.Onboard.OnboardViewModel
import com.example.ws_preparation.presentation.Onboard.components.OnboardScreen
import com.example.ws_preparation.presentation.SignIn.SignInViewModel
import com.example.ws_preparation.presentation.SignIn.components.SignInScreen
import com.example.ws_preparation.presentation.SignUp.SignUpViewModel
import com.example.ws_preparation.presentation.SignUp.components.SignUpScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Onboard_AuthorizationNavGraph(
    navHostController: NavHostController,
    startDestination: String,
) {

    NavHost(navHostController, startDestination,
    modifier= Modifier.background(Color.White)){
        composable(Route.OnboardScreen.route){
            val viewModel: OnboardViewModel = hiltViewModel()
            OnboardScreen(viewModel = viewModel, navController = navHostController)
        }
        composable(Route.SignUpScreen.route){
            val viewModel: SignUpViewModel = hiltViewModel()
            SignUpScreen(viewModel, navHostController)
        }
        composable(Route.SignInScreen.route){
            val viewModel: SignInViewModel = hiltViewModel()
            SignInScreen(viewModel, navHostController)
        }
        composable(Route.ForgotPasswordScreen.route){
            val viewModel: ForgotPasswordViewModel = hiltViewModel()
            ForgotPasswordScreen(viewModel, navHostController)
        }
        composable(Route.OTPVerificationScreen.route){
            val viewModel: OTPVerificationViewModel = hiltViewModel()
            OTPVerificationScreen(viewModel, navHostController)
        }
    }
}
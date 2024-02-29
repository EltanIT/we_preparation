package com.example.ws_preparation.presentation.navgraph

sealed class Route(
    val route: String
) {

    object OnboardScreen: Route("OnboardScreen")
    object SignUpScreen: Route("SignUpScreen")
    object SignInScreen: Route("SignInScreen")
    object ForgotPasswordScreen: Route("ForgotPasswordScreen")
    object OTPVerificationScreen: Route("OTPVerificationScreen?email={email}")
    object NewPasswordScreen: Route("NewPasswordScreen?email={email}")
    object HomeScreen: Route("HomeScreen")



}
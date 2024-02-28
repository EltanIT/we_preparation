package com.example.ws_preparation.presentation.navgraph

sealed class Route(
    val route: String
) {

    object OnboardScreen: Route("OnboardScreen")
    object SignUpScreen: Route("SignUpScreen")
    object SignInScreen: Route("SignInScreen")



}
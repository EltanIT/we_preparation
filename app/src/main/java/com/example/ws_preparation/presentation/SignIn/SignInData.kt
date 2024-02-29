package com.example.ws_preparation.presentation.SignIn

data class SignInData(
    val email: String = "",
    val password: String = "",
    val rememberPas: Boolean = false,
) {
}
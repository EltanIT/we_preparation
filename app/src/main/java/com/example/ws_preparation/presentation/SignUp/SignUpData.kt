package com.example.ws_preparation.presentation.SignUp

import kotlinx.serialization.Serializable


@Serializable
data class SignUpData(
    val fullName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val password: String = "",
)
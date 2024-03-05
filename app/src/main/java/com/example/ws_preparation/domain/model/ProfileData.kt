package com.example.ws_preparation.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class ProfileData(
    val fullName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val balance: String = "",
    val role: String = "",
)
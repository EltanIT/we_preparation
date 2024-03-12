package com.example.ws_preparation.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class ProfileData(
    val user_id: String = "",
    val fullName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val balance: String = "",
    val image: String = "",
    val role: String = "",
)
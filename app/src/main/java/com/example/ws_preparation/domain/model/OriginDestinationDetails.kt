package com.example.ws_preparation.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class OriginDestinationDetails(
    val address: String? = "",
    val state: String? = "",
    val phoneNumber: String? = "",
    val others: String? = "",
)

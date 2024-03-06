package com.example.ws_preparation.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class PackageDetails(
    val packageItems: String? = "",
    val weightItem: String? = "",
    val worthItems: String? = "",
)

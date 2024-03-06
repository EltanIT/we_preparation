package com.example.ws_preparation.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class ChargesPackageData(
    var deliveryCharges: String = "",
    var instantDelivery: String = "",
    var taxCharges: String = "",
    var packageTotal: String = "",
)

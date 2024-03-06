package com.example.ws_preparation.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class PackageData(
    val order_id: String = "",
    val originDetails: OriginDestinationDetails = OriginDestinationDetails(),
    val destinationDetails: List<OriginDestinationDetails> = listOf(),
    val packageDetails: PackageDetails = PackageDetails(),
    var uuid: String = "",
    val chargesPackageData: ChargesPackageData = ChargesPackageData()
)

package com.example.ws_preparation.domain.model

data class PackageData(
    val originDetails: OriginDestinationDetails = OriginDestinationDetails(),
    val destinationDetails: List<OriginDestinationDetails> = listOf(),
    val packageDetails: PackageDetails = PackageDetails(),
    var uuid: String = "",
    val chargesPackageData: ChargesPackageData = ChargesPackageData()
)

package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.model.ProfileData

interface PostPackageRepository {

        suspend fun postPackage(packageData: PackageData)
}
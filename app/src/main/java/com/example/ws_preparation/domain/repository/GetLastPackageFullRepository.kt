package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.model.ProfileData

interface GetLastPackageFullRepository {

        suspend fun getPackage(): PackageData
}
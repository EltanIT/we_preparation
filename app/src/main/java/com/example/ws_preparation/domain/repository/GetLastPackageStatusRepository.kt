package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.model.ProfileData

interface GetLastPackageStatusRepository {

        suspend fun getPackage(): PackageData
}
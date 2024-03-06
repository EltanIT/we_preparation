package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.PackageData

interface GetLastPackageTrackRepository {

        suspend fun getPackageTrack(): PackageData
}
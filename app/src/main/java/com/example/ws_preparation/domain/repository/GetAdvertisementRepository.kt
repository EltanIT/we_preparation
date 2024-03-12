package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.AdvertisementData
import com.example.ws_preparation.domain.model.ProfileData

interface GetAdvertisementRepository {

        suspend fun get(): List<AdvertisementData>
}
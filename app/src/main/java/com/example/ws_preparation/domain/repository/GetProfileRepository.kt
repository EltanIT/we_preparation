package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.ProfileData

interface GetProfileRepository {

        suspend fun getProfile(): ProfileData
}
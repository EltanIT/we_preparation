package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.ProfileData

interface GetChatsProfileRepository {

        suspend fun getChats(role: String): List<ProfileData>
}
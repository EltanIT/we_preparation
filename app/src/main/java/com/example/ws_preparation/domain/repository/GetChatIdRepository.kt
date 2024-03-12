package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.ProfileData

interface GetChatIdRepository {

        suspend fun get(recipient_id: String, role: String): String
}
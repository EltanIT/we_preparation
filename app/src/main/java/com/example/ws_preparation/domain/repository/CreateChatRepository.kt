package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.ProfileData

interface CreateChatRepository {

        suspend fun create(id: String, role: String)
}
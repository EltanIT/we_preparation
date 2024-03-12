package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.AdvertisementData
import com.example.ws_preparation.domain.model.ProfileData

interface CreateMessageRepository {

        suspend fun postMessage(message: String, chat_id: String, recipient_id: String)
}
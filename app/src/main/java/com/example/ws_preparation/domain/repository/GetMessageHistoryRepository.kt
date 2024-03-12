package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.domain.model.MessageData
import com.example.ws_preparation.domain.model.ProfileData

interface GetMessageHistoryRepository {

        suspend fun get(chat_id: String): List<MessageData>
}
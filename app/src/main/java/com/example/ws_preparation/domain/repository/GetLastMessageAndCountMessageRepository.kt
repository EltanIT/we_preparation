package com.example.ws_preparation.domain.repository

interface GetLastMessageRepository {

        suspend fun getLastMessage(role: String, user_id: String): String
}
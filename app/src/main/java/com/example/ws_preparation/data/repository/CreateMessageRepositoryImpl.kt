package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.repository.CreateChatRepository
import com.example.ws_preparation.domain.repository.CreateMessageRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest

class CreateMessageRepositoryImpl: CreateMessageRepository {

    override suspend fun postMessage(message: String, chat_id: String, recipient_id: String) {
        val data: Map<String, String> =  mapOf(
            "sender" to (client.auth.currentUserOrNull()?.id?:""),
            "recipient" to recipient_id,
            "chat_id" to chat_id,
            "message" to message,
        )
        client.postgrest["message"].insert(data)
    }
}
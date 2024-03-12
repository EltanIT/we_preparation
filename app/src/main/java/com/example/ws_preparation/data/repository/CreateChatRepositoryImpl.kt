package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.repository.CreateChatRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest

class CreateChatRepositoryImpl: CreateChatRepository {

    override suspend fun create(id: String, role: String) {
        val data: Map<String, String> = if (role == "client"){
            mapOf(
                "client_id" to (client.auth.currentUserOrNull()?.id?:""),
                "courier_id" to id
            )
        } else{
            mapOf(
                "client_id" to id,
                "courier_id" to (client.auth.currentUserOrNull()?.id?:"")
            )
        }
        client.postgrest["chat"].insert(data)
    }
}
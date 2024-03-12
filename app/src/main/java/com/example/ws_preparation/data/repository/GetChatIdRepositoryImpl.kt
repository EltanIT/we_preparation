package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.repository.GetChatIdRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import org.json.JSONObject

class GetChatIdRepositoryImpl: GetChatIdRepository {

    override suspend fun get(recipient_id: String, role: String): String {
        val data = client.postgrest["chat"].select(
            columns = Columns.list(
                "chat_id"
            )
        ){
            filter {
                if (role=="client"){
                    eq("courier_id", recipient_id)
                    eq("client_id", client.auth.currentUserOrNull()?.id?:"")
                }else{
                    eq("client_id", recipient_id)
                    eq("courier_id", client.auth.currentUserOrNull()?.id?:"")
                }
            }
            single()
        }.data

        return JSONObject(data).getString("chat_id")
    }
}
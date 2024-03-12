package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.repository.GetLastMessageRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import org.json.JSONObject

class GetLastMessageRepositoryImpl: GetLastMessageRepository {

    override suspend fun getLastMessage(role: String, user_id: String): String {
        val data = client.postgrest["chat"].select(
            columns = Columns.list(
                "last_message"
            )
        ){
            filter {
                if (role=="client"){
                    eq("client_id", client.auth.currentUserOrNull()?.id?:"")
                    eq("courier_id", user_id)
                }else{
                    eq("client_id", user_id)
                    eq("courier_id", client.auth.currentUserOrNull()?.id?:"")
                }
            }
            single()
        }.data

        return JSONObject(data).getString("last_message")
    }
}
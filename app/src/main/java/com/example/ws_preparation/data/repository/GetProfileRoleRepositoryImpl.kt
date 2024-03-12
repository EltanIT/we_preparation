package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.repository.GetProfileRoleRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import org.json.JSONObject

class GetProfileRoleRepositoryImpl: GetProfileRoleRepository {
    override suspend fun getRole(): String {
        val data = client.postgrest["profile"].select(
            columns = Columns.list(
                "role"
            )
        ){
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
            }
            single()
        }

        return JSONObject(data.data).getString("role")
    }
}
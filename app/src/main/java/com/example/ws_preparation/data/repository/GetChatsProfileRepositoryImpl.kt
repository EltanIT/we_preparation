package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.GetChatsProfileRepository
import com.example.ws_preparation.domain.repository.GetProfileRoleRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.serialization.json.Json
import org.json.JSONObject

class GetChatsProfileRepositoryImpl: GetChatsProfileRepository {

    override suspend fun getChats(role: String): List<ProfileData> {
        val data = client.postgrest["profile"].select(
            columns = Columns.list(
                "user_id",
                "fullName",
                "image"
            )
        ){
            filter {
                if (role=="client"){
                    eq("role", "courier")
                }else{
                    eq("role", "client")
                }
            }
        }.data

        return Json { ignoreUnknownKeys = true }.decodeFromString(data)
    }
}
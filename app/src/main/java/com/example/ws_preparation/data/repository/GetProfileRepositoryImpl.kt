package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.GetProfileRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.serialization.json.Json

class GetProfileRepositoryImpl: GetProfileRepository {
    override suspend fun getProfile(): ProfileData {
       val data = client.postgrest["profile"].select{
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
            }
            single()
        }

        return Json { ignoreUnknownKeys = true }.decodeFromString(data.data)

    }
}
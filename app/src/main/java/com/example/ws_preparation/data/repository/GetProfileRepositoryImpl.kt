package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.GetProfileRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class GetProfileRepositoryImpl: GetProfileRepository {
    override suspend fun getProfile(): ProfileData {
       return client.postgrest["profile"].select(
           Columns.list(
               "fullName",
               "phoneNumber",
               "email",
               "balance",
                "role",
               "image"
           )
       ) {
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
            }
            single()
        }.decodeSingle<ProfileData>()
    }
}
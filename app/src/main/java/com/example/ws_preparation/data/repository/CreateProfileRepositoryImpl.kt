package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import io.github.jan.supabase.postgrest.postgrest

class CreateProfileRepositoryImpl {
    suspend fun invoke(profile: Map<String, String>){
        client.postgrest["profile"].insert(profile)
    }
}
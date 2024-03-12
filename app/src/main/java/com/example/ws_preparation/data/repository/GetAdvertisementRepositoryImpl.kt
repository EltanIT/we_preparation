package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.model.AdvertisementData
import com.example.ws_preparation.domain.repository.GetAdvertisementRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.serialization.json.Json

class GetAdvertisementRepositoryImpl: GetAdvertisementRepository {
    override suspend fun get(): List<AdvertisementData> {
        val data = client.postgrest["advertisement"].select(
            columns = Columns.list(
                "image"
            )
        ){}.data

        return Json { ignoreUnknownKeys = true }.decodeFromString(data)
    }
}
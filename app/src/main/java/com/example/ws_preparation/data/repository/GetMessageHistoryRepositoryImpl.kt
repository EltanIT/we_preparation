package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.model.AdvertisementData
import com.example.ws_preparation.domain.model.MessageData
import com.example.ws_preparation.domain.repository.GetAdvertisementRepository
import com.example.ws_preparation.domain.repository.GetMessageHistoryRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import kotlinx.serialization.json.Json

class GetMessageHistoryRepositoryImpl: GetMessageHistoryRepository {

    override suspend fun get(chat_id: String): List<MessageData> {
        val data = client.postgrest["message"].select(
        ){
            filter {
                eq("chat_id", chat_id)
            }
        }.data

        return Json { ignoreUnknownKeys = true }.decodeFromString(data)
    }
}
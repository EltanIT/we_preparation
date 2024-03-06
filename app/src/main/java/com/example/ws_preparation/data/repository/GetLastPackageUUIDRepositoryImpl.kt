package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.repository.GetLastPackageTrackRepository
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.Order
import kotlinx.serialization.json.Json
import org.json.JSONArray

class GetLastPackageUUIDRepositoryImpl: GetLastPackageTrackRepository {
    override suspend fun getPackageTrack(): PackageData {
        val data = client.postgrest["package"].select(
            columns = Columns.list(
                "uuid",
                "order_id"
            )
        ) {
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
            }
            order("created_at", Order.DESCENDING)
        }

        val jsonObject = JSONArray(data.data).getJSONObject(0)
        return Json { ignoreUnknownKeys = true }.decodeFromString(jsonObject.toString())
    }
}
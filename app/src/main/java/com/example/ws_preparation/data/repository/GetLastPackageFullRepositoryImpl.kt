package com.example.ws_preparation.data.repository

import android.util.Log
import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.model.ChargesPackageData
import com.example.ws_preparation.domain.model.OriginDestinationDetails
import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.model.PackageDetails
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.GetLastPackageFullRepository
import com.example.ws_preparation.domain.repository.GetProfileRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.Order
import kotlinx.serialization.json.Json
import org.json.JSONArray
import org.json.JSONObject

class GetLastPackageFullRepositoryImpl: GetLastPackageFullRepository {
    override suspend fun getPackage(): PackageData {
        val data = client.postgrest["package"].select {
            filter {
                eq("user_id", client.auth.currentUserOrNull()?.id?:"")
            }
            order("created_at", Order.DESCENDING)
        }.data
        Log.i("supabaseClient", data)
        val jsonObject = JSONArray(data).getJSONObject(0)
        val originDetails = Gson().fromJson(jsonObject.getString("originDetails"), OriginDestinationDetails::class.java)
        val chargesPackageData = Gson().fromJson(jsonObject.getString("chargesPackageData"), ChargesPackageData::class.java)

        val type = object: TypeToken<List<OriginDestinationDetails>>(){}.type
        val destinationDetails = Gson().fromJson(jsonObject.getString("destinationDetails"), type) as List<OriginDestinationDetails>

        val packageDetails = Gson().fromJson(jsonObject.getString("packageDetails"), PackageDetails::class.java)
        val uuid = jsonObject.getString("uuid")
        val order_id = jsonObject.getString("order_id")

        return PackageData(
            order_id, originDetails, destinationDetails, packageDetails, uuid, chargesPackageData
        )
    }
}
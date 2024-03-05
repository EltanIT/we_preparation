package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.GetProfileRepository
import com.example.ws_preparation.domain.repository.PostPackageRepository
import com.google.gson.Gson
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.postgrest.query.Columns

class PostPackageRepositoryImpl: PostPackageRepository {

    override suspend fun postPackage(packageData: PackageData) {
        val dataMap = mapOf(
            "originDetails" to Gson().toJson(packageData.originDetails),
            "chargesPackageData" to Gson().toJson(packageData.chargesPackageData),
            "destinationDetails" to Gson().toJson(packageData.destinationDetails),
            "packageDetails" to Gson().toJson(packageData.packageDetails),
            "uuid" to packageData.uuid,
        )
        client.postgrest["package"].insert(dataMap)
    }
}
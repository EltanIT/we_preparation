package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.data.repository.CreateProfileRepositoryImpl
import com.example.ws_preparation.data.repository.SignUpRepositoryImpl
import com.example.ws_preparation.domain.entities.ProfileData

class CreateProfileRepository {

    private val createProfileRepositoryImpl = CreateProfileRepositoryImpl()

    suspend fun invoke(profileData: ProfileData){
        val data = mapOf(
            "fullName" to profileData.fullName,
            "email" to profileData.email,
            "phoneNumber" to profileData.phoneNumber,
        )
        createProfileRepositoryImpl.invoke(data)
    }
}
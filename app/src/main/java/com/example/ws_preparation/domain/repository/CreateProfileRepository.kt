package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.data.repository.CreateProfileRepositoryImpl
import com.example.ws_preparation.domain.model.ProfileData

class CreateProfileRepository {

    private val createProfileRepositoryImpl = CreateProfileRepositoryImpl()

    suspend fun invoke(fullName: String, email: String, phoneNumber: String){
        val data = mapOf(
            "fullName" to fullName,
            "email" to email,
            "phoneNumber" to phoneNumber,
        )
        createProfileRepositoryImpl.invoke(data)
    }
}
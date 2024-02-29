package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.data.repository.SignUpRepositoryImpl
import com.example.ws_preparation.domain.entities.ProfileData

class SignUpRepository {

    private val signUpRepositoryImpl = SignUpRepositoryImpl()

    suspend fun invoke(profileData: ProfileData){
        signUpRepositoryImpl.invoke(profileData.email, profileData.password)
    }
}
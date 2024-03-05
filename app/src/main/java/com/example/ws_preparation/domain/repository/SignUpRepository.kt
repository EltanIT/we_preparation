package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.data.repository.SignUpRepositoryImpl
import com.example.ws_preparation.domain.model.ProfileData

class SignUpRepository {

    private val signUpRepositoryImpl = SignUpRepositoryImpl()

    suspend fun invoke(email: String, password: String){
        signUpRepositoryImpl.invoke(email, password)
    }
}
package com.example.ws_preparation.domain.repository

import com.example.ws_preparation.data.repository.SignInRepositoryImpl
import com.example.ws_preparation.presentation.SignIn.SignInData

class SignInRepository {

    private val signInRepositoryImpl = SignInRepositoryImpl()

    suspend fun invoke(signInData: SignInData){
        signInRepositoryImpl.invoke(signInData.email, signInData.password)
    }
}
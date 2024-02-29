package com.example.ws_preparation.data.repository

import com.example.ws_preparation.data.network.SupabaseInit.client
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email

class SignUpRepositoryImpl {
    suspend fun invoke(email1: String, password1: String){
        client.auth.signUpWith(Email){
            email = email1
            password = password1
        }
    }
}
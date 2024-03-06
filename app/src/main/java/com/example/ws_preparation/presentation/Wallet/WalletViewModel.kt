package com.example.ws_preparation.presentation.Wallet

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.GetProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class WalletViewModel @Inject constructor(
    private val getProfileRepository: GetProfileRepository
): ViewModel() {

    var profile by mutableStateOf(ProfileData())
        private set


    init {
        getProfile()
    }

    private fun getProfile() {
        viewModelScope.launch {
            try {
                val profile = getProfileRepository.getProfile()
                withContext(Dispatchers.Main){
                    this@WalletViewModel.profile = profile
                }
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }
}
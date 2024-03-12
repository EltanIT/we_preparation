package com.example.ws_preparation.presentation.Home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.model.AdvertisementData
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.GetAdvertisementRepository
import com.example.ws_preparation.domain.repository.GetProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProfileRepository: GetProfileRepository,
    private val getAdvertisementRepository: GetAdvertisementRepository,
): ViewModel() {


    var profile by mutableStateOf(ProfileData())
        private set

    val advertisement = mutableStateListOf<AdvertisementData>()

    var search by mutableStateOf("")
        private set


    init {
        getProfile()
        getAdvertisementData()
    }

    private fun getAdvertisementData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val advert = getAdvertisementRepository.get()
                withContext(Dispatchers.Main){
                    advertisement.addAll(advert)
                }
                Log.i("supabaseClient", advert.size.toString())
                Log.i("supabaseClient", advertisement.size.toString())
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }


    fun redactSearch(txt: String){
        search = txt
    }

    private fun getProfile() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val profile = getProfileRepository.getProfile()
                withContext(Dispatchers.Main){
                    this@HomeViewModel.profile = profile
                }
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }


}
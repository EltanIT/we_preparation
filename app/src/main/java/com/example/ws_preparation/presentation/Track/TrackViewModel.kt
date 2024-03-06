package com.example.ws_preparation.presentation.Track

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.model.DeliveryData
import com.example.ws_preparation.domain.repository.GetLastPackageTrackRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TrackViewModel @Inject constructor(
    private val getLastPackageUUIDRepository: GetLastPackageTrackRepository,
): ViewModel() {

    var uuid by mutableStateOf("")
        private set

    var status by mutableStateOf(DeliveryData())
        private set

    var exception by mutableStateOf(DeliveryData())
        private set


    init {
        getUUID()
    }

    private fun getUUID() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = getLastPackageUUIDRepository.getPackageTrack()
                withContext(Dispatchers.Main){
                    uuid = data.order_id
                }
                getStatus()
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }

    private fun getStatus() {
        viewModelScope.launch(Dispatchers.IO) {
            try {

            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }
}
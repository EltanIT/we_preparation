package com.example.ws_preparation.presentation.SendAPackage2

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.repository.GetLastPackageFullRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class SendAPackage2ViewModel @Inject constructor(
    private val getLastPackageFullRepository: GetLastPackageFullRepository
): ViewModel() {


    var data by mutableStateOf(PackageData())
        private set

    var stateSuccessful by mutableStateOf(false)
        private set


    init {
        getPackage()
    }

    private fun getPackage() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = getLastPackageFullRepository.getPackage()
                withContext(Dispatchers.Main){
                    this@SendAPackage2ViewModel.data = data
                }
            }   catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }

    fun successfulDelivery() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                withContext(Dispatchers.Main){
                    stateSuccessful  = true
                }
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }


        }
    }
}
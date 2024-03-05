package com.example.ws_preparation.presentation.SendAPackageReceipt

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.repository.PostPackageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SendAPackageReceiptViewModel @Inject constructor(
    private val postPackageRepository: PostPackageRepository
): ViewModel() {

    var data by mutableStateOf(PackageData())
        private set

    var statePost by mutableStateOf("")
        private set

    var isGetting = false

    fun setDataInit(data: PackageData){
        this.data = data
        calculate()
    }

    private fun calculate() {
        if (!isGetting){
            val delivery = 2500* data.destinationDetails.size
            val instantDelivery = (100..300).random()
            val taxCharges = ((delivery+instantDelivery)*5)/100

            data.chargesPackageData.instantDelivery = "N$instantDelivery"
            data.chargesPackageData.deliveryCharges = "N$delivery"
            data.chargesPackageData.taxCharges = "N$taxCharges"
            data.chargesPackageData.packageTotal = "N"+(delivery+instantDelivery+taxCharges).toString()
            isGetting = true
        }


    }


    fun post(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                postPackageRepository.postPackage(data)
                statePost = "true"
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }

        }

    }


}
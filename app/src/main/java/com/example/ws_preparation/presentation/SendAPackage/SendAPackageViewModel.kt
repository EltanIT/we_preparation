package com.example.ws_preparation.presentation.SendAPackage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ws_preparation.domain.model.OriginDestinationDetails
import com.example.ws_preparation.domain.model.PackageData
import com.example.ws_preparation.domain.model.PackageDetails
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.UUID
import javax.inject.Inject


@HiltViewModel
class SendAPackageViewModel @Inject constructor(): ViewModel() {

    private var packageData by mutableStateOf(PackageData())
        private set

    var originDetails by mutableStateOf(OriginDestinationDetails())
        private set

    var destinationDetails = mutableStateListOf(OriginDestinationDetails())
        private set

    var packageDetails by mutableStateOf(PackageDetails())
        private set


    fun redactOriginAddress(txt: String){
        originDetails = originDetails.copy(address = txt)
    }
    fun redactOriginState(txt: String){
        originDetails = originDetails.copy(state = txt)
    }
    fun redactOriginPhoneNumber(txt: String){
        originDetails = originDetails.copy(phoneNumber = txt)
    }
    fun redactOriginOthers(txt: String){
        originDetails = originDetails.copy(others = txt)
    }


    fun redactDestinationAddress(txt: String, index: Int){
        destinationDetails[index] = destinationDetails[index].copy(address = txt)
    }
    fun redactDestinationState(txt: String, index: Int){
        destinationDetails[index] = destinationDetails[index].copy(state = txt)
    }
    fun redactDestinationPhoneNumber(txt: String, index: Int){
        destinationDetails[index] = destinationDetails[index].copy(phoneNumber = txt)
    }
    fun redactDestinationOthers(txt: String, index: Int){
        destinationDetails[index] = destinationDetails[index].copy(others = txt)
    }


    fun redactPackageItems(txt: String){
        packageDetails = packageDetails.copy(packageItems = txt)
    }
    fun redactPackageWeight(txt: String){
        packageDetails = packageDetails.copy(weightItem = txt)
    }
    fun redactPackageWorth(txt: String){
        packageDetails = packageDetails.copy(worthItems = txt)
    }

    fun addDestination() {
        destinationDetails.add(OriginDestinationDetails())
    }

    fun createPackage() {
        if (packageData.uuid.isEmpty()){
            packageData.uuid = "R-" + UUID.randomUUID().toString()
        }
        packageData = packageData.copy(packageDetails = packageDetails)
        packageData = packageData.copy(originDetails = originDetails)
        packageData = packageData.copy(destinationDetails = destinationDetails)
    }

    fun getData(): String {
        return Gson().toJson(packageData)
    }
}
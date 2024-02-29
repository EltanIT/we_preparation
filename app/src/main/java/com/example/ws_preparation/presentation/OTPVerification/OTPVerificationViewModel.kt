package com.example.ws_preparation.presentation.OTPVerification

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class OTPVerificationViewModel @Inject constructor(): ViewModel() {


    var code by mutableStateOf("")
        private set

    var isError by mutableStateOf(false)
        private set

    var stateButton by mutableStateOf(false)
        private set
    
    
    fun redactCode(txt: String){
        if(txt.length<=6){
            code = txt
        }
        checkStateButton()
    }


    fun checkStateButton(){
        stateButton = code.length == 6
    }
}
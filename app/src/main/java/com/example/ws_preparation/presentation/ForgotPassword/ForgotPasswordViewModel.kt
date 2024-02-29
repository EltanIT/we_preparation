package com.example.ws_preparation.presentation.ForgotPassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(): ViewModel() {

    var email by mutableStateOf("")
        private set

    var stateButton by mutableStateOf(false)
        private set


    fun redactEmail(txt: String){
        email = txt
        checkStateButton()
    }

    fun checkStateButton(){
        stateButton = email.isNotEmpty()
    }
}
package com.example.ws_preparation.presentation.SignIn

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.repository.SignInRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor(): ViewModel() {

    private val signInRepository = SignInRepository()


    var data by mutableStateOf(SignInData())
        private set

    var buttonState by mutableStateOf(false)
        private set

    var exception by mutableStateOf("")
        private set


    fun redactEmail(txt: String){
        data = data.copy(email = txt)
        checkButtonState()
    }

    fun redactPassword(txt: String){
        data = data.copy(password = txt)
        checkButtonState()
    }


    fun redactRememberPassword(){
        data = data.copy(rememberPas = !data.rememberPas)
    }

    fun signIn() {
        viewModelScope.launch {
            try {
                signInRepository.invoke(data)
                exception = "true"
            }catch (e: Exception){
                exception = e.message.toString()
            }
        }
    }


    fun checkButtonState(){
        buttonState = (
                data.email.isNotEmpty()
                        && data.password.isNotEmpty()
                )
    }

    fun closeException() {
        exception = ""
    }
}
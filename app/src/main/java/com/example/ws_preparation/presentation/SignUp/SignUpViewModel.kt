package com.example.ws_preparation.presentation.SignUp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.data.util.Constants
import com.example.ws_preparation.domain.model.ProfileData
import com.example.ws_preparation.domain.repository.CreateProfileRepository
import com.example.ws_preparation.domain.repository.SignUpRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
): ViewModel() {

    private val signUpRepository =  SignUpRepository()
    private val createProfileRepository =  CreateProfileRepository()


    var profile by mutableStateOf(SignUpData())
        private set

    var confirmPassword by mutableStateOf("")
        private set

    var privacyCheck by mutableStateOf(false)
        private set

    var buttonState by mutableStateOf(false)
        private set


    var exception by mutableStateOf("")
        private set




    fun redactFullName(txt: String){
        profile = profile.copy(fullName = txt)
        checkButtonState()
    }

    fun redactPhoneNumber(txt: String){
        profile = profile.copy(phoneNumber = txt)
        checkButtonState()
    }

    fun redactEmail(txt: String){
        profile = profile.copy(email = txt)

        checkButtonState()
    }

    fun redactPassword(txt: String){
        profile = profile.copy(password = txt)
        checkButtonState()
    }

    fun redactConfirmPassword(txt: String){
        confirmPassword = txt
        checkButtonState()
    }

    fun redactPrivacyCheck(){
        privacyCheck = !privacyCheck
        checkButtonState()
    }


    fun signUp(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                signUpRepository.invoke(profile.email, profile.password)
                createProfileRepository.invoke(profile.fullName, profile.email, profile.phoneNumber)
                withContext(Dispatchers.Main){
                    exception = "true"
                }
            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    exception = e.message.toString()
                }
            }
        }
    }

    fun signInWithGoogle() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    exception = e.message.toString()
                }
            }
        }
    }


    private fun checkButtonState(){
        buttonState = (
                profile.email.isNotEmpty()
                        && profile.fullName.isNotEmpty()
                        && profile.phoneNumber.isNotEmpty()
                        && profile.password.isNotEmpty()
                        && profile.password.equals(confirmPassword)
                        && privacyCheck
                        && emailValid()
                )
    }


    private fun emailValid(): Boolean{

       val isValid = Constants.emailValidPattern.toRegex().matches(profile.email)
        Log.i("emailValid",isValid.toString() )
        return isValid
    }

    fun closeException() {
        exception = ""
    }

}
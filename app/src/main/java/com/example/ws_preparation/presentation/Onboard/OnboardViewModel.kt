package com.example.ws_preparation.presentation.Onboard

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.model.OnboardPage
import com.example.ws_preparation.domain.useCases.onboard.OnboardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class OnboardViewModel @Inject constructor(
    private val onboardUseCases: OnboardUseCases
): ViewModel() {

    var page by mutableStateOf(OnboardPage())
        private set

    var nextText by mutableStateOf("Next")
        private set

    var skipState by mutableStateOf(false)
        private set

    var isLastItem by mutableStateOf(false)
        private set


    init {
        getNextPage()
    }

    fun getNextPage(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val page = onboardUseCases.getItemFromQueue()
                val nextText = onboardUseCases.getButtonStateQueue()
                withContext(Dispatchers.Main){
                    this@OnboardViewModel.page = page
                    this@OnboardViewModel.nextText = nextText
                    isLastItem = (nextText.equals("Sign Up"))
                }
                Log.i("onboardClient", page.title)
            }catch (e: Exception){
                Log.i("onboardClient", e.message.toString())
            }
        }
    }

    fun skipQueue() {
        viewModelScope.launch(Dispatchers.IO)
        {
            try {
                onboardUseCases.clearQueue()
                withContext(Dispatchers.Main){
                    skipState = true
                }
            }catch (e: Exception){
                Log.i("onboardClient", e.message.toString())
            }
        }
    }
}
package com.example.ws_preparation.presentation.activity.mainActivity

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ws_preparation.domain.useCases.onboard.OnboardUseCases
import com.example.ws_preparation.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val onboardUseCases: OnboardUseCases
): ViewModel() {

    var startDestination by mutableStateOf("")
        private set

    init {
        checkQueueState()
    }

    private fun checkQueueState() {
        viewModelScope.launch {
            try {
                val queueIsEmpty = onboardUseCases.isQueueIsEmpty()
                if (queueIsEmpty != null){
                    if (queueIsEmpty){
                        withContext(Dispatchers.Main){
                            startDestination = Route.SignInScreen.route
                        }
                    }else{
                        withContext(Dispatchers.Main){
                            startDestination = Route.OnboardScreen.route
                        }
                    }
                }else{
                    onboardUseCases.createDefaultQueue()
                }
                Log.i("supabaseClient", startDestination)
            }catch (e: Exception){
                Log.i("supabaseClient", e.message.toString())
            }
        }
    }
}
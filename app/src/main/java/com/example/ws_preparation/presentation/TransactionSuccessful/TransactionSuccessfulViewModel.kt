package com.example.ws_preparation.presentation.TransactionSuccessful

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class TransactionSuccessfulViewModel @Inject constructor(

): ViewModel() {


    var uuid by mutableStateOf("")
        private set

    var isSuccessful by mutableStateOf(false)
        private set


    fun setUUID(uuid: String){
        this.uuid = uuid
    }


    init {
        timer()
    }

    fun timer(){
        object: CountDownTimer(2000, 1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                isSuccessful = true
            }

        }
    }



}
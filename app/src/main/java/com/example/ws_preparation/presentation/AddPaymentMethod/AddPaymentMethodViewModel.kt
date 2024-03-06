package com.example.ws_preparation.presentation.AddPaymentMethod

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddPaymentMethodViewModel @Inject constructor(): ViewModel() {


    val methodList by mutableStateOf(listOf(
        MethodData(
            "Pay with wallet",
            "complete the payment using your e wallet",
        ),
        MethodData(
            "Credit / debit card",
            "complete the payment using your debit card",
        ),
    ))


    var selectedMethod by mutableStateOf(0)
        private set

    var selectedCard by mutableStateOf(0)
        private set


    fun redactMethod(index: Int){
        selectedMethod = index
    }

    fun redactCard(index: Int){
        selectedCard = index
    }
}
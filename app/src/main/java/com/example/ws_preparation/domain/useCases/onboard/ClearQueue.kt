package com.example.ws_preparation.domain.useCases.onboard

import com.example.ws_preparation.domain.entities.OnboardPage
import com.example.ws_preparation.domain.manger.QueueManger
import com.google.gson.Gson
import java.util.LinkedList

class ClearQueue(
    val queueManger: QueueManger
) {

    suspend operator fun invoke(){
        queueManger.saveQueue(Gson().toJson(LinkedList<OnboardPage>()))
    }
}
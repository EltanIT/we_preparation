package com.example.ws_preparation.domain.useCases.onboard

import com.example.ws_preparation.domain.entities.onboardPageQueueDefault
import com.example.ws_preparation.domain.manger.QueueManger
import com.google.gson.Gson

class CreateDefaultQueue(
    val queueManger: QueueManger
) {

    suspend operator fun invoke(){
        queueManger.saveQueue(Gson().toJson(onboardPageQueueDefault))
    }
}
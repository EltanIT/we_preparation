package com.example.ws_preparation.domain.useCases.onboard

import com.example.ws_preparation.domain.entities.OnboardPage
import com.example.ws_preparation.domain.entities.onboardPageQueueDefault
import com.example.ws_preparation.domain.manger.QueueManger
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.LinkedList

class GetItemFromQueue(
    val queueManger: QueueManger
) {

    suspend operator fun invoke(): OnboardPage{
        val dataJson = queueManger.readQueue()
        val gson = Gson()
        if (dataJson!=null){
            val type = object: TypeToken<LinkedList<OnboardPage>>(){}.type
            val list = gson.fromJson(dataJson, type) as LinkedList<OnboardPage>
            val page = list.pop()
            queueManger.saveQueue(gson.toJson(list))
            return page
        }else{
            queueManger.saveQueue(gson.toJson(onboardPageQueueDefault))
            invoke()
        }
        return OnboardPage()
    }
}
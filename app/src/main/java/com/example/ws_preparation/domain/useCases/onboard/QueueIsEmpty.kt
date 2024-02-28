package com.example.ws_preparation.domain.useCases.onboard

import com.example.ws_preparation.domain.entities.OnboardPage
import com.example.ws_preparation.domain.manger.QueueManger
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.LinkedList

class QueueIsEmpty(
    val queueManger: QueueManger
) {

    suspend operator fun invoke(): Boolean?{
        val dataJson = queueManger.readQueue()
        val gson = Gson()
        return if (dataJson!=null){
            val type = object: TypeToken<LinkedList<OnboardPage>>(){}.type
            val list = gson.fromJson(dataJson, type) as LinkedList<OnboardPage>
            list.size == 0
        }else{
            null
        }
    }
}
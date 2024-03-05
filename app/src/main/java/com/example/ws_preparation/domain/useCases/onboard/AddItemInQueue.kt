package com.example.ws_preparation.domain.useCases.onboard

import com.example.ws_preparation.domain.model.OnboardPage
import com.example.ws_preparation.domain.manger.QueueManger
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.LinkedList

class AddItemInQueue(
    val queueManger: QueueManger
) {

    suspend operator fun invoke(page: OnboardPage){
        val dataJson = queueManger.readQueue()
        val gson = Gson()
        if (dataJson!=null){
            val type = object: TypeToken<LinkedList<OnboardPage>>(){}.type
            val list = gson.fromJson(dataJson, type) as LinkedList<OnboardPage>
            list.add(page)
            queueManger.saveQueue(gson.toJson(list))
        }else{
            val list = LinkedList<OnboardPage>()
            list.add(page)
            queueManger.saveQueue(gson.toJson(list))
        }
    }
}
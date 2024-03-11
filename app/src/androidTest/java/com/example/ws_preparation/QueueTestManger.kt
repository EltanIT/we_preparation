package com.example.ws_preparation

import com.example.ws_preparation.domain.manger.QueueManger
import com.example.ws_preparation.domain.model.OnboardPage
import com.example.ws_preparation.domain.model.onboardPageQueueDefault
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.LinkedList

class QueueTestManger: QueueManger {

    var queue = LinkedList<OnboardPage>()
    init {
        queue.addAll(onboardPageQueueDefault)
    }

    override suspend fun readQueue(): String? {
        return Gson().toJson(queue)
    }

    override suspend fun saveQueue(queue: String) {
        val type = object: TypeToken<LinkedList<OnboardPage>>(){}.type
        this.queue = Gson().fromJson(queue, type)
    }
}
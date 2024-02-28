package com.example.ws_preparation.domain.manger

interface QueueManger {

    suspend fun readQueue(): String?
    suspend fun saveQueue(queue: String)
}
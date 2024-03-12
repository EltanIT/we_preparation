package com.example.ws_preparation.domain.model

import kotlinx.serialization.Serializable


@Serializable
data class MessageData(
    val message: String = "",
    val sender: String = "",
    val recipient: String = "",
)
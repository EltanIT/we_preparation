package com.example.ws_preparation.presentation.Chats

data class ChatsScreenData(
    val user_id: String? = "",
    val name: String? = "",
    val image: String? = "",
    val lastMessage: String? = "",
    val countMessage: Int? = 1,
) {
}
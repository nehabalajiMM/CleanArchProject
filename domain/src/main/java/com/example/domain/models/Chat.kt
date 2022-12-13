package com.example.domain.models

data class Chat(
    val name: String,
    val url: String,
    val chat: String,
    val time: String,
    val unreadCount: String,
    val chatId: Int = 0
)

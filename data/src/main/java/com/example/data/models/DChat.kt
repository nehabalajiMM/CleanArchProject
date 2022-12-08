package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DChat(
    val name: String,
    val url: String,
    val chat: String,
    val time: String,
    val unreadCount: String,
    @PrimaryKey(autoGenerate = true)
    val chatId: Int = 0
)

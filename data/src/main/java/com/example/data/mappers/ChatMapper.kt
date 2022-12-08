package com.example.data.mappers

import com.example.data.models.DChat
import com.example.domain.models.Chat

fun DChat.toChat() = Chat(name, url, chat, time, unreadCount, chatId)
fun Chat.toDChat() = DChat(name, url, chat, time, unreadCount, chatId)

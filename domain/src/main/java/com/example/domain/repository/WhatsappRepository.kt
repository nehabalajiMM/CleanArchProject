package com.example.domain.repository

import com.example.domain.models.Chat
import kotlinx.coroutines.flow.Flow

interface WhatsappRepository {
    suspend fun getAllChatsForUser(): Flow<List<Chat>>
    suspend fun addChat(chat: Chat)
}

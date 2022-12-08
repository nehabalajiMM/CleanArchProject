package com.example.data.repository

import com.example.data.mappers.toChat
import com.example.data.mappers.toDChat
import com.example.data.sources.local.Dao
import com.example.domain.models.Chat
import com.example.domain.repository.WhatsappRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WhatsappRepositoryImpl @Inject constructor(
    private val dao: Dao
) : WhatsappRepository {

    override suspend fun getAllChatsForUser(): Flow<List<Chat>> {
        return dao.fetchAllChats().map { dChatList ->
            dChatList.map { dChat ->
                dChat.toChat()
            }
        }
    }

    override suspend fun addChat(chat: Chat) {
        return dao.addChat(chat.toDChat())
    }
}

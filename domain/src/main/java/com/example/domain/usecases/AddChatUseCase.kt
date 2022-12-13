package com.example.domain.usecases

import com.example.domain.models.Chat
import com.example.domain.repository.WhatsappRepository

class AddChatUseCase(
    private val repository: WhatsappRepository
) {
    suspend operator fun invoke(chat: Chat) = repository.addChat(chat)
}

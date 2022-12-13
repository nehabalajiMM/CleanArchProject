package com.example.domain.usecases

import com.example.domain.models.Chat
import com.example.domain.repository.WhatsappRepository
import kotlinx.coroutines.flow.Flow

class FetchChatsUseCase(
    private val repository: WhatsappRepository
) {
    suspend operator fun invoke(): Flow<List<Chat>> = repository.getAllChatsForUser()
}

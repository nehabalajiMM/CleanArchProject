package com.example.domain.di

import com.example.domain.repository.WhatsappRepository
import com.example.domain.usecases.AddChatUseCase
import com.example.domain.usecases.FetchChatsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideAddChatUseCase(repository: WhatsappRepository) = AddChatUseCase(repository)

    @Singleton
    @Provides
    fun provideFetchChatsUseCase(repository: WhatsappRepository) = FetchChatsUseCase(repository)
}

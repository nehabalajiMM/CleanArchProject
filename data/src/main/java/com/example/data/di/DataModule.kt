package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.repository.WhatsappRepositoryImpl
import com.example.data.sources.local.Dao
import com.example.data.sources.local.WhatsappDatabase
import com.example.domain.repository.WhatsappRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideWhatsappDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, WhatsappDatabase::class.java, "whatsapp_database").build()

    @Singleton
    @Provides
    fun provideNoteDao(whatsappDb: WhatsappDatabase) = whatsappDb.getDao()

    @Singleton
    @Provides
    fun provideNoteRepository(dao: Dao): WhatsappRepository = WhatsappRepositoryImpl(dao)
}

package com.example.cleanarchproject.di

import com.example.mylibrary.navigator.ComposeNavigator
import com.example.mylibrary.navigator.composeNavigator.WhatsappCloneComposeNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun provideComposeNavigator(whatsappCloneComposeNavigator: WhatsappCloneComposeNavigator): ComposeNavigator
}

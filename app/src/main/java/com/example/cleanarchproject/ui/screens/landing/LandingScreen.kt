package com.example.cleanarchproject.ui.screens.chat

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.cleanarchproject.ui.screens.landing.components.ChatsItemView
import com.example.data.sources.local.chatsList

@Composable
fun LandingScreen() {
    LazyColumn {
        items(chatsList) {
            ChatsItemView(chat = it)
        }
    }
}

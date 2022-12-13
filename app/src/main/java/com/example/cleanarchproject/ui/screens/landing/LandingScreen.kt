package com.example.cleanarchproject.ui.screens.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cleanarchproject.ui.screens.landing.components.ChatsItemView
import com.example.cleanarchproject.ui.screens.landing.viewmodel.LandingScreenVM
import com.example.data.mappers.toDChat

@Composable
fun LandingScreen(
    landingScreenVM: LandingScreenVM = hiltViewModel()
) {
    val chatsListFlow by landingScreenVM.chatsList.collectAsState()
    val chatsList by chatsListFlow.collectAsState(initial = emptyList())

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(chatsList) {
            ChatsItemView(chat = it.toDChat())
            Divider(color = Color.Gray)
        }
    }
}

package com.example.chat.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.chat.ui.landing.LandingScreen
import com.example.mylibrary.navigator.WhatsappRoute
import com.example.mylibrary.navigator.WhatsappScreen

fun NavGraphBuilder.chatNavGraph() {
    navigation(
        startDestination = WhatsappScreen.ChatList.route,
        route = WhatsappRoute.OnBoarding.name
    ) {
        composable(WhatsappScreen.ChatList.route) {
            LandingScreen()
        }
    }
}

package com.example.ui_authentication.nav // ktlint-disable package-name

import android.app.Activity
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.mylibrary.navigator.WhatsappRoute
import com.example.mylibrary.navigator.WhatsappScreen
import com.example.ui_authentication.ui.WhatsappSignUpScreen

fun NavGraphBuilder.authNavGraph(activity: Activity) {
    navigation(
        startDestination = WhatsappScreen.Auth.route,
        route = WhatsappRoute.Auth.name
    ) {
        composable(WhatsappScreen.Auth.route) {
            WhatsappSignUpScreen(activity = activity)
        }
    }
}

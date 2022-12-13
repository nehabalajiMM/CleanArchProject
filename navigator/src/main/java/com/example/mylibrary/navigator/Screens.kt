package com.example.mylibrary.navigator

import androidx.navigation.NamedNavArgument

sealed class WhatsappScreen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    object ChatList : WhatsappScreen("chatsList")
    object ChatScreen : WhatsappScreen("chatScreen")
    object Registration : WhatsappScreen("registration")
    object Login : WhatsappScreen("login")
}

sealed class WhatsappRoute(val name: String) {
    object OnBoarding : WhatsappRoute("onboardingRoute")
    object Auth : WhatsappRoute("authenticationRoute")
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}

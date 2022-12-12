package com.example.cleanarchproject.ui

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.chat.nav.chatNavGraph
import com.example.cleanarchproject.ui.theme.CleanArchProjectTheme
import com.example.mylibrary.navigator.ComposeNavigator
import com.example.mylibrary.navigator.WhatsappRoute
import com.example.ui_authentication.nav.authNavGraph
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var composeNavigator: ComposeNavigator
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        setContent {
            CleanArchProjectTheme {
                val navController = rememberNavController()
                LaunchedEffect(Unit) {
                    composeNavigator.handleNavigationCommands(navController)
                }
                NavHost(
                    navController = navController,
                    startDestination = if (auth.currentUser == null) {
                        WhatsappRoute.Auth.name
                    } else {
                        WhatsappRoute.OnBoarding.name
                    }
                ) {
                    authNavGraph(
                        this@MainActivity as Activity
                    )
                    chatNavGraph()
                }
            }
        }
    }
}

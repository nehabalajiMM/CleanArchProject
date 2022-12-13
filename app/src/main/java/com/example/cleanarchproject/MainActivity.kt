package com.example.cleanarchproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cleanarchproject.ui.screens.chat.LandingScreen
import com.example.cleanarchproject.ui.theme.CleanArchProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchProjectTheme {
                LandingScreen()
            }
        }
    }
}

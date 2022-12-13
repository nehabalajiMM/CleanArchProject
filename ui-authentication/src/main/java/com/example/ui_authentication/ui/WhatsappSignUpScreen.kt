package com.example.ui_authentication.ui // ktlint-disable package-name

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.* // ktlint-disable no-wildcard-imports
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ui_authentication.ui.theme.Typography
import com.example.ui_authentication.ui.theme.colorGreen
import com.example.ui_authentication.vm.AuthVM

@Composable
fun WhatsappSignUpScreen(
    activity: Activity,
    authVM: AuthVM = hiltViewModel()
) {
    var phone by rememberSaveable { mutableStateOf("") }
    var code by rememberSaveable { mutableStateOf("") }
    var isVisible by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(top = 16.dp)
            .padding(horizontal = 8.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextComponent(text = "Verify your phone number", Typography.h3)
        TextComponent(text = "Whatsapp will send an SMS message to verify your phone number. Enter your country code and phone number.", Typography.h6)
        OutlinedTextField(
            value = phone,
            label = { Text(text = "Enter a number") },
            onValueChange = {
                phone = it
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorGreen,
                unfocusedBorderColor = colorGreen,
                focusedLabelColor = colorGreen
            )
        )
        if (!isVisible) {
            Button(onClick = {
                authVM.login(phone, activity = activity)
                isVisible = true
            }) {
                Text(text = "Next")
            }
        }
        if (isVisible) {
            OutlinedTextField(
                value = code,
                label = { Text(text = "Enter the verification code") },
                onValueChange = {
                    code = it
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorGreen,
                    unfocusedBorderColor = colorGreen,
                    focusedLabelColor = colorGreen
                )
            )
            Button(onClick = {
                authVM.isVerificationCodeCorrect(code)
                isVisible = true
            }) {
                Text(text = "Submit")
            }
        }
    }
}

@Composable
fun TextComponent(text: String, style: TextStyle) {
    Text(text = text, style = style, textAlign = TextAlign.Center)
}

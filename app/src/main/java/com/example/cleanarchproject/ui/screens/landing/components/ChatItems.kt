package com.example.cleanarchproject.ui.screens.landing.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cleanarchproject.R
import com.example.cleanarchproject.ui.theme.Typography
import com.example.cleanarchproject.ui.theme.colorGreen
import com.example.data.models.DChat

@Composable
fun ChatsItemView(chat: DChat) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        AsyncImage(
            model = chat.url,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape).size(40.dp),
            placeholder = painterResource(id = R.drawable.ic_launcher_background)
        )
        Spacer(modifier = Modifier.size(12.dp))
        Column(modifier = Modifier.weight(3.0f, true)) {
            TextComponent(chat.name, Typography.body2)
            Spacer(modifier = Modifier.size(2.dp))
            TextComponent(chat.chat, Typography.body1)
        }
        Column(modifier = Modifier.weight(1.0f, true), horizontalAlignment = Alignment.End) {
            TextComponent(chat.time, Typography.subtitle1)
            Spacer(modifier = Modifier.size(2.dp))
            UnreadCount(chat)
        }
    }
}

@Composable
fun TextComponent(text: String, style: TextStyle) {
    Text(
        text = text,
        style = style,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun UnreadCount(chat: DChat) {
    if (chat.unreadCount != "0") {
        Column(horizontalAlignment = CenterHorizontally) {
            Box(
                modifier = Modifier.size(20.dp)
                    .background(color = colorGreen, shape = CircleShape)
                    .align(CenterHorizontally)
            ) {
                Text(
                    text = chat.unreadCount,
                    style = Typography.subtitle2,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview
@Composable
fun showChats() {
    ChatsItemView(chat = DChat("test", "https://picsum.photos/200", "jkqefiaksj cd", "2:33 pm", "1"))
}

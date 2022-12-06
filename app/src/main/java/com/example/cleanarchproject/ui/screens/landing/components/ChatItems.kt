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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.cleanarchproject.R
import com.example.cleanarchproject.ui.theme.colorDarkGreen
import com.example.cleanarchproject.ui.theme.colorGreen
import com.example.data.models.DChat

@Composable
fun ChatsItemView(chat: DChat) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .clickable {
//            loadNextScreen(
//                DUser(
//                    id = 2,
//                    chat.name,
//                    chat.url
//                )
//            ) }
            .padding(top = 4.dp, bottom = 4.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            AsyncImage(
                model = chat.url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape).size(40.dp),
                placeholder = painterResource(id = R.drawable.ic_launcher_background)
            )
            Spacer(modifier = Modifier.size(12.dp))
            Column(modifier = Modifier.weight(3.0f, true)) {
                Text(chat.name)
                Spacer(modifier = Modifier.size(2.dp))
                userChat(chat)
            }
            Column(modifier = Modifier.weight(1.0f, true), horizontalAlignment = Alignment.End) {
                MessageTime(chat)
                Spacer(modifier = Modifier.size(2.dp))
                unreadCount(chat)
            }
        }
    }
}

@Composable
fun userChat(chat: DChat) {
    Text(
        text = chat.chat,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Gray
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun MessageTime(chat: DChat) {
    Text(
        text = chat.time,
        style = TextStyle(
            fontSize = 12.sp,
            color = colorGreen
        )
    )
}

@Composable
fun unreadCount(chat: DChat) {
    if (chat.unreadCount != "0") {
        setupUnreadCount(chat.unreadCount)
    }
}

@Composable
fun setupUnreadCount(count: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier.size(20.dp)
                .background(color = colorGreen, shape = CircleShape)
                .align(CenterHorizontally)
        ) {
            Text(
                text = count,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = colorDarkGreen
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun showChats() {
    ChatsItemView(chat = DChat("test", "https://picsum.photos/200", "jkqefiaksj cd", "2:33 pm", "1"))
}

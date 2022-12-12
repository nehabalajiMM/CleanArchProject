package com.example.chat.ui.landing.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.mappers.toChat
import com.example.data.models.DChat
import com.example.domain.models.Chat
import com.example.domain.usecases.AddChatUseCase
import com.example.domain.usecases.FetchChatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.* // ktlint-disable no-wildcard-imports
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingScreenVM @Inject constructor(
    private val addChatUseCase: AddChatUseCase,
    private val fetchChatsUseCase: FetchChatsUseCase
) : ViewModel() {

    private val _chatsList = MutableStateFlow<Flow<List<Chat>>>(emptyFlow())
    val chatsList = _chatsList.asStateFlow()

    init {
        insertchatIntoDb(
            DChat(
                "Shahrukh Khan",
                "https://static.toiimg.com/thumb/msid-69902898,imgsize-115506,width-800,height-600,resizemode-75/69902898.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                "Yesterday",
                "0",
                1
            )
        )
        insertchatIntoDb(
            DChat(
                "Salman Khan",
                "https://starsunfolded.com/wp-content/uploads/2013/08/Salman-Khan-picsss.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                "Friday",
                "0",
                2
            )
        )
        insertchatIntoDb(
            DChat(
                "Akshay Kumar",
                "https://images.outlookindia.com/public/uploads/articles/2019/12/7/Akshay-Kumar-3_571_855.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                "Thursday",
                "2",
                3
            )
        )
        insertchatIntoDb(
            DChat(
                "Aamir Khan",
                "https://filmfare.wwmindia.com/content/2020/apr/aamirkhan41588085012.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                "Monday",
                "5",
                4
            )
        )
        insertchatIntoDb(
            DChat(
                "Amitabh Bachan",
                "https://c.tribune.com.pk/2017/11/1551269-amitabhbachancopy-1509963604.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                "22/04/20",
                "6",
                5
            )
        )
        insertchatIntoDb(
            DChat(
                "Kartik Aryan",
                "https://imagevars.gulfnews.com/2018/12/03/TAB_181130_Kartik_Aaryan_AKK_16a08539c08_medium.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                "18/04/20",
                "7",
                6
            )
        )
        insertchatIntoDb(
            DChat(
                "Saif Ali Khan",
                "https://images.khaleejtimes.com/storyimage/KT/20181015/ARTICLE/181019430/AR/0/AR-181019430.jpg&MaxW=780&imageVersion=16by9&NCS_modified=20181015110716",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                "10/04/20",
                "1",
                7
            )
        )
        insertchatIntoDb(
            DChat(
                "Shahid Kapoor",
                "https://static.toiimg.com/thumb/msid-71336384,width-800,height-600,resizemode-75,imgsize-32094/71336384.jpg",
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
                "9/04/20",
                "0",
                8
            )
        )
        fetchChatsFromDb()
    }

    private fun fetchChatsFromDb() = viewModelScope.launch {
        _chatsList.value = fetchChatsUseCase()
    }

    fun insertchatIntoDb(chat: DChat) {
        viewModelScope.launch {
            addChatUseCase(chat.toChat())
        }
    }
}

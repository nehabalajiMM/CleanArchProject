package com.example.data.mappers

import com.example.data.models.DUser
import com.example.domain.models.User

fun User.toDUser() = DUser(name, imageUrl, id)
fun DUser.toUser() = User(name, imageUrl, id)

package com.example.data.mappers

import com.example.data.models.DUser
import com.example.domain.models.User

fun User.toDUser() = DUser(id, name, imageUrl)
fun DUser.toUser() = User(id, name, imageUrl)

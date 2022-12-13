package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DUser(
    val name: String,
    val imageUrl: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

package com.example.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.models.DChat
import com.example.data.models.DUser

@Database(
    entities = [DChat::class, DUser::class],
    version = 1,
    exportSchema = false
)
abstract class WhatsappDatabase : RoomDatabase() {
    abstract fun getDao(): Dao
}

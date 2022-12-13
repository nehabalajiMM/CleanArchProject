package com.example.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.models.DChat
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addChat(dChat: DChat)

    @Query("SELECT * FROM DChat")
    fun fetchAllChats(): Flow<List<DChat>>
}

package com.example.euro24application.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PlayerDao {
    @Query("SELECT * FROM player")
    fun readAll(): Flow<List<Player>>
}
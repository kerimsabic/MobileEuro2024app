package com.example.euro24application.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "player")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int,
    val position: String,
)









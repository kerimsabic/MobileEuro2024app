package com.example.euro24application.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    fun getUserByCredentials(email: String, password: String): User?

    @Query("SELECT * FROM users")
    fun get_all(): LiveData<List<User>>
}
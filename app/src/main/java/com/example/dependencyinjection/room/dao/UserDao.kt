package com.example.dependencyinjection.room.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.dependencyinjection.room.entity.AppUsers

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: AppUsers)
}
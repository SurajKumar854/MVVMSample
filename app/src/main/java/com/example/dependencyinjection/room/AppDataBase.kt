package com.example.dependencyinjection.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dependencyinjection.room.dao.UserDao
import com.example.dependencyinjection.room.entity.AppUsers

@Database(entities = [AppUsers::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DATABASE_NAME = "mohit_db"
    }

}
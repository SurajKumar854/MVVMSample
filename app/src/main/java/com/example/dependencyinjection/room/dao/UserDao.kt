package com.example.dependencyinjection.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dependencyinjection.room.entity.AppUsers
import com.google.android.material.circularreveal.CircularRevealHelper.Strategy

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: AppUsers)

    @Query("Select * from Users ")
    fun getUsersList(): LiveData<List<AppUsers>>
}
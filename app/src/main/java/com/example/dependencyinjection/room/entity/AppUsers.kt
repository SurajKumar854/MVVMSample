package com.example.dependencyinjection.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class AppUsers(
    var id: String?,
    var lastName: String?,
    var mobileNo: String?,
) {
    @PrimaryKey(autoGenerate = true)
    var pid: Int? = null
}
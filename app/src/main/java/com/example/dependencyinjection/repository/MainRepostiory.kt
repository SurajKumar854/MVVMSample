package com.example.dependencyinjection.repository

import androidx.lifecycle.LiveData
import com.example.dependencyinjection.retrofit.networkApi.Api
import com.example.dependencyinjection.retrofit.response.ProductPostResponse
import com.example.dependencyinjection.retrofit.response.UserListResponse
import com.example.dependencyinjection.room.AppDataBase
import com.example.dependencyinjection.room.entity.AppUsers
import javax.inject.Inject


class MainRepostiory @Inject constructor(private val api: Api, private val roomDB: AppDataBase) {


    suspend fun getUser(): ProductPostResponse {
        return api.getData()
    }

    suspend fun getUserList(): UserListResponse {
        return api.getUsersList()
    }

    fun insertUser(user: AppUsers) {
        roomDB.userDao().insertUser(user)
    }

    fun getUserListFromLocalDB(): LiveData<List<AppUsers>> {
        return roomDB.userDao().getUsersList()
    }

}
package com.example.dependencyinjection.repository

import com.example.dependencyinjection.retrofit.networkApi.Api
import com.example.dependencyinjection.retrofit.response.ProductPostResponse
import com.example.dependencyinjection.retrofit.response.UserListResponse
import com.example.dependencyinjection.room.AppDataBase
import com.example.dependencyinjection.room.entity.AppUsers
import javax.inject.Inject


class MainRepostiory @Inject constructor(val api: Api, val roomDB: AppDataBase) {


    suspend fun getUser(): ProductPostResponse {
        return api.getData()
    }

    suspend fun getUserList(): UserListResponse {
        return api.getUsersList()
    }

    suspend fun insertUser(user: AppUsers) {
        roomDB.userDao().insertUser(user)
    }

}
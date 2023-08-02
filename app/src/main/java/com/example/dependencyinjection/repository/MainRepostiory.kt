package com.example.dependencyinjection.repository

import com.example.dependencyinjection.retrofit.networkApi.Api
import com.example.dependencyinjection.retrofit.response.ProductPostResponse
import com.example.dependencyinjection.retrofit.response.UserListResponse
import javax.inject.Inject


class MainRepostiory @Inject constructor(val api: Api) {


    suspend fun getUser(): ProductPostResponse {
        return api.getData()
    }

    suspend fun getUserList(): UserListResponse {
        return api.getUsersList()
    }

}
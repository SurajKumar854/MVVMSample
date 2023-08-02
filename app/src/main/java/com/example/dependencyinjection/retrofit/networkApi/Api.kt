package com.example.dependencyinjection.retrofit.networkApi

import com.example.dependencyinjection.retrofit.response.ProductPostResponse
import com.example.dependencyinjection.retrofit.response.UserListResponse
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    suspend fun getData(): ProductPostResponse


    @GET("/users")
    suspend fun getUsersList(): UserListResponse
}
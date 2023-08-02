package com.example.dependencyinjection.retrofit.utilis

import com.example.dependencyinjection.retrofit.networkApi.Api

sealed class ApiState<out T> {
    object Loading : ApiState<Nothing>()
    class Success<T>(val data: T) : ApiState<T>()
}


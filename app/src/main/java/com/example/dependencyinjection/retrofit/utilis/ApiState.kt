package com.example.dependencyinjection.retrofit.utilis

import com.example.dependencyinjection.retrofit.networkApi.Api
import com.example.dependencyinjection.retrofit.response.UserListResponse

sealed class ApiState {
    object Loading : ApiState()
    class Success(val data: UserListResponse) : ApiState()
}


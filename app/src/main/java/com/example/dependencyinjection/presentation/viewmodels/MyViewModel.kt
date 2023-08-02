package com.example.dependencyinjection.presentation.viewmodels


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dependencyinjection.repository.MainRepostiory
import com.example.dependencyinjection.retrofit.response.ProductPostResponse
import com.example.dependencyinjection.retrofit.response.UserListResponse
import com.example.dependencyinjection.retrofit.utilis.ApiState
import com.example.dependencyinjection.room.entity.AppUsers
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    @ApplicationContext private val context: Context, private val mainRepostiory: MainRepostiory
) : ViewModel() {

    private val _loadImageResourceResponse: MutableLiveData<ProductPostResponse> = MutableLiveData()
    var loadImageResourceResponseObserver: LiveData<ProductPostResponse> =
        _loadImageResourceResponse


    private val _userListResponse: MutableLiveData<ApiState<UserListResponse>> = MutableLiveData()
    var userListResponseObserver: LiveData<ApiState<UserListResponse>> = _userListResponse


    var userListResponseLocalDBObserver: LiveData<List<AppUsers>>


    private val _createAppUserResponse: MutableLiveData<ApiState<Unit>> = MutableLiveData()
    var _createAppUserResponseObserver: LiveData<ApiState<Unit>> =
        _createAppUserResponse


    init {
        userListResponseLocalDBObserver = mainRepostiory.getUserListFromLocalDB()

    }

    suspend fun getUserPosts() = viewModelScope.launch {
        _loadImageResourceResponse.postValue(mainRepostiory.getUser())
    }

    suspend fun getUsersList() = viewModelScope.launch {
        _userListResponse.postValue(ApiState.Loading)
        delay(1000)
        _userListResponse.postValue(ApiState.Success(mainRepostiory.getUserList()))


    }

    suspend fun insertUser(appUsers: AppUsers) = viewModelScope.launch {
        _createAppUserResponse.postValue(ApiState.Loading)
        _createAppUserResponse.postValue(ApiState.Success(mainRepostiory.insertUser(appUsers)))
    }

    fun getUserListLocalDB(): LiveData<List<AppUsers>> {
        return userListResponseLocalDBObserver
    }

}
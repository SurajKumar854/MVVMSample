package com.example.dependencyinjection.di

import com.example.dependencyinjection.retrofit.networkApi.Api
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideApiService(): Api = Retrofit.Builder().run {
             baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
             }.create(Api::class.java)

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder().build()


}
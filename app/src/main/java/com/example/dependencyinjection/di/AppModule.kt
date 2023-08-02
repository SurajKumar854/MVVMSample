package com.example.dependencyinjection.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dependencyinjection.retrofit.networkApi.Api
import com.example.dependencyinjection.room.AppDataBase
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideRoomDB(@ApplicationContext context: Context): AppDataBase = Room.run {
        databaseBuilder(
            context = context,
            AppDataBase::class.java,
            AppDataBase.DATABASE_NAME
        ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi.Builder().build()


}
package com.ard.newsoffline.di

import android.content.Context
import androidx.room.Room
import com.ard.newsoffline.data.local.db.AppDatabase
import com.ard.newsoffline.data.remote.api.PostApi
import com.ard.newsoffline.data.repository.PostRepositoryImpl
import com.ard.newsoffline.domain.repository.PostRepository
import com.ard.newsoffline.network.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

object AppModule {

    fun provideDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build()

    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun providePostApi(retrofit: Retrofit): PostApi =
        retrofit.create(PostApi::class.java)

    fun providePostRepository(context : Context) : PostRepository {
        val db = provideDatabase(context = context)
        val api = providePostApi(provideRetrofit())

        return PostRepositoryImpl(
            api = api,
            dao = db.postDao()
        )
    }
}
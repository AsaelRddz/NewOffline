package com.ard.newsoffline

import android.app.Application
import com.ard.newsoffline.di.AppModule
import com.ard.newsoffline.domain.repository.PostRepository

class MyApp : Application() {
    //lateinit var repository: PostRepository

    override fun onCreate() {
        super.onCreate()
        //repository = AppModule.providePostRepository(this)

    }
}
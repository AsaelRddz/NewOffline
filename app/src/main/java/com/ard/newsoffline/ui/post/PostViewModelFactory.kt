package com.ard.newsoffline.ui.post

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ard.newsoffline.di.AppModule

class PostViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = AppModule.providePostRepository(context)
        return PostViewModel(repository) as T
    }
}
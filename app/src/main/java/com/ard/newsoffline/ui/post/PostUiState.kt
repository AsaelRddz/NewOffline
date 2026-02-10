package com.ard.newsoffline.ui.post

import com.ard.newsoffline.domain.model.Post

sealed class PostUiState {
    object Loading : PostUiState()
    data class Success(val posts : List<Post>) : PostUiState()
    data class Error(val message : String) : PostUiState()
}
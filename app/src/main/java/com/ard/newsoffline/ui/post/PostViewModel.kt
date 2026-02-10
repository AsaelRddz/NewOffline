package com.ard.newsoffline.ui.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ard.newsoffline.domain.repository.PostRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val repository: PostRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PostUiState>(PostUiState.Loading)
    val uiState : StateFlow<PostUiState> = _uiState

    init {
        loadPosts()
    }

    private fun loadPosts() {
        viewModelScope.launch {
            try {
                val posts = repository.getPosts()
                _uiState.value = PostUiState.Success(posts = posts)
            } catch (e : Exception) {
                _uiState.value = PostUiState.Error("Something went wrong")
            }
        }
    }
}
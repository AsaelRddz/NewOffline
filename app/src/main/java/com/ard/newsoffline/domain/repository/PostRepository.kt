package com.ard.newsoffline.domain.repository

import com.ard.newsoffline.domain.model.Post

interface PostRepository {
    suspend fun getPosts() : List<Post>
}
package com.ard.newsoffline.data.remote.api

import com.ard.newsoffline.data.remote.dto.PostDto
import retrofit2.http.GET

// PostApi → define QUÉ endpoint llamas
// endpoints
interface PostApi {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}
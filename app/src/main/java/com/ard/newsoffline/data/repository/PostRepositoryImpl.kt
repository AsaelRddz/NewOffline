package com.ard.newsoffline.data.repository

import com.ard.newsoffline.data.local.db.PostDao
import com.ard.newsoffline.data.mapper.toDomain
import com.ard.newsoffline.data.mapper.toEntity
import com.ard.newsoffline.data.remote.api.PostApi
import com.ard.newsoffline.domain.model.Post
import com.ard.newsoffline.domain.repository.PostRepository

class PostRepositoryImpl(
    private val api : PostApi,
    private val dao : PostDao
) : PostRepository {

    override suspend fun getPosts(): List<Post> {
        return try {
            // api download
            val remotePosts = api.getPosts()

            // clear bd
            dao.clear()

            // api -> bd
            dao.insertAll(remotePosts.map { it.toEntity() })

            // api -> domain
            remotePosts.map { it.toDomain() }
        } catch (e : Exception) {

            // bd -> domain
            dao.getPosts().map { it.toDomain() }
        }
    }
}
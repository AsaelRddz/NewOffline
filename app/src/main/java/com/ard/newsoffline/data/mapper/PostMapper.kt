package com.ard.newsoffline.data.mapper

import com.ard.newsoffline.data.local.entity.PostEntity
import com.ard.newsoffline.data.remote.dto.PostDto
import com.ard.newsoffline.domain.model.Post

// ".toEntity()" indica que es una extension
fun PostDto.toEntity() = PostEntity(
    id = id,
    title = title,
    body = body
)

fun PostEntity.toDomain() = Post(
    id = id,
    title = title,
    content = body
)

fun PostDto.toDomain() = Post(
    id = id,
    title = title,
    content = body
)
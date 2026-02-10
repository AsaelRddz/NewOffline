package com.ard.newsoffline.data.mapper

import com.ard.newsoffline.data.local.entity.PostEntity
import com.ard.newsoffline.data.remote.dto.PostDto
import com.ard.newsoffline.domain.model.Post

// ".toEntity()" indica que es una extension
// api -> bd
fun PostDto.toEntity() = PostEntity(
    id = id,
    title = title,
    body = body
)

// api -> domain
fun PostDto.toDomain() = Post(
    id = id,
    title = title,
    content = body
)

// bd -> domain
fun PostEntity.toDomain() = Post(
    id = id,
    title = title,
    content = body
)
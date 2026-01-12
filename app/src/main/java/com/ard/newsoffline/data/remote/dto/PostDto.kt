package com.ard.newsoffline.data.remote.dto

// PostDto → define CÓMO viene la respuesta
data class PostDto(
    val userId : Int,
    val id : Int,
    val title : String,
    val body : String
)
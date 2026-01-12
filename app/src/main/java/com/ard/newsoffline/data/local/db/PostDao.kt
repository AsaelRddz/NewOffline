package com.ard.newsoffline.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ard.newsoffline.data.local.entity.PostEntity

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    suspend fun getPosts(): List<PostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(post : List<PostEntity>)

    @Query("DELETE FROM posts")
    suspend fun clear()
}
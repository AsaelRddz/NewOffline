package com.ard.newsoffline.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ard.newsoffline.data.local.entity.PostEntity

@Database(
    entities = [PostEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
}
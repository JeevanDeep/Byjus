package com.jeevan.byjus.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jeevan.byjus.headlines.home.response.headlines.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getHeadlinesDao(): HeadlineDao
}
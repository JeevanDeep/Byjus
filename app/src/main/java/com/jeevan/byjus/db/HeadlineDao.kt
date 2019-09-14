package com.jeevan.byjus.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jeevan.byjus.headlines.home.response.headlines.Article

@Dao
interface HeadlineDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeadlines(list: List<Article>)

    @Query("SELECT * FROM Article")
    suspend fun getAllHeadlines(): List<Article>

    @Query("SELECT * FROM Article WHERE id = :id")
    suspend fun getArticleById(id: Long): Article
}
package com.jeevan.byjus.headlines.home

import com.jeevan.byjus.headlines.home.response.headlines.Article
import com.jeevan.byjus.network.NetworkResult


interface HeadlinesDataSource {
    suspend fun getHeadlines(): NetworkResult<List<Article>>
}
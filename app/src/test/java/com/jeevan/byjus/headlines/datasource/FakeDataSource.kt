package com.jeevan.byjus.headlines.datasource

import com.jeevan.byjus.headlines.HeadlinesRepo
import com.jeevan.byjus.headlines.home.HeadlinesDataSource
import com.jeevan.byjus.headlines.home.response.headlines.Article
import com.jeevan.byjus.headlines.home.response.headlines.Source
import com.jeevan.byjus.network.ApiClient
import com.jeevan.byjus.network.NetworkResult

class FakeDataSource() : HeadlinesDataSource {
    override suspend fun getHeadlines(): NetworkResult<List<Article>> {

        return NetworkResult.Success(listOf(Article("", "", "", "", Source(",", ""), "", "")))
    }
}
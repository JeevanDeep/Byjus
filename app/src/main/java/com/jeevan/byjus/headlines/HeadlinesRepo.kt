package com.jeevan.byjus.headlines

import com.jeevan.byjus.db.HeadlineDao
import com.jeevan.byjus.headlines.home.response.headlines.Article
import com.jeevan.byjus.network.ApiClient
import com.jeevan.byjus.network.NetworkResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeadlinesRepo @Inject constructor(
    private val apiClient: ApiClient,
    private val dao: HeadlineDao
) {

    suspend fun getHeadlines(): NetworkResult<List<Article>> {
        var result: NetworkResult<List<Article>>? = null
        runCatching {
            val response = apiClient.getHeadlines()
            dao.insertHeadlines(response.articles)

            val responseFromDb = dao.getAllHeadlines()
            val list = mutableListOf<Article>()

            list.addAll(responseFromDb)
            result = NetworkResult.Success(list)
        }.onFailure {
            val responseFromDb = dao.getAllHeadlines()
            result = if (responseFromDb.isNotEmpty()) {
                NetworkResult.Success(responseFromDb)
            } else {
                NetworkResult.Error(it)
            }
        }
        return result!!
    }
}
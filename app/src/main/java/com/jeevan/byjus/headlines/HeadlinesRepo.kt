package com.jeevan.byjus.headlines

import com.jeevan.byjus.db.HeadlineDao
import com.jeevan.byjus.headlines.home.response.headlines.HeadlinesListResponse
import com.jeevan.byjus.network.ApiClient
import com.jeevan.byjus.network.NetworkResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeadlinesRepo @Inject constructor(
    private val apiClient: ApiClient,
    private val dao: HeadlineDao
) {

    suspend fun getHeadlines(): NetworkResult<HeadlinesListResponse> {
        var result: NetworkResult<HeadlinesListResponse>? = null
        runCatching {
            val response = apiClient.getHeadlines()
            result = NetworkResult.Success(response)
            dao.insertHeadlines(response.articles)
        }.onFailure {
            val responseFromDb = dao.getAllHeadlines()
            result = if (responseFromDb.isNotEmpty()) {
                NetworkResult.Success(HeadlinesListResponse(responseFromDb, "", 0))
            } else {
                NetworkResult.Error(it)
            }
        }
        return result!!
    }
}
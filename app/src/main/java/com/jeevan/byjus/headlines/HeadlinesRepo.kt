package com.jeevan.byjus.headlines

import com.jeevan.byjus.headlines.home.response.headlines.HeadlinesListResponse
import com.jeevan.byjus.network.ApiClient
import com.jeevan.byjus.network.NetworkResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeadlinesRepo @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getHeadlines(): NetworkResult<HeadlinesListResponse> {
        var result: NetworkResult<HeadlinesListResponse>? = null
        runCatching {
            val response = apiClient.getHeadlines()
            result = NetworkResult.Success(response)

            // todo add db implementation
        }.onFailure {
            result = NetworkResult.Error(it)
        }
        return result!!
    }
}
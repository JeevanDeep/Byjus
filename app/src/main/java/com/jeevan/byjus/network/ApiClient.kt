package com.jeevan.byjus.network

import com.jeevan.byjus.home.response.headlines.HeadlinesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET(NetworkConstants.GET_HEADLINES)
    suspend fun getHeadlines(@Query("country") country: String = "us"): HeadlinesListResponse
}
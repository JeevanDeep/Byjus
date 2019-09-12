package com.jeevan.byjus.network

import com.jeevan.byjus.home.response.headlines.HeadlinesListResponse
import retrofit2.http.GET

interface ApiClient {

    @GET(NetworkConstants.GET_HEADLINES)
    suspend fun getHeadlines(): HeadlinesListResponse
}
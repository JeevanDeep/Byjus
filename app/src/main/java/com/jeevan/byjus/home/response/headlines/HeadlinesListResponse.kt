package com.jeevan.byjus.home.response.headlines


import com.google.gson.annotations.SerializedName

data class HeadlinesListResponse(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)
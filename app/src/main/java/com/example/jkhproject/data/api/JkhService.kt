package com.example.jkhproject.data.api

import com.example.jkhproject.data.models.network.NewsNetModel
import retrofit2.http.GET

interface JkhService {

    @GET("news.json")
    suspend fun getNews(): List<NewsNetModel>
}
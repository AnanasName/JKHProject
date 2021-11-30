package com.example.jkhproject.data.api

import com.example.jkhproject.data.models.network.NewsNetModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JkhService {

    @GET("711bebe0ecb137ab49be")
    suspend fun getNews(): List<NewsNetModel>

}
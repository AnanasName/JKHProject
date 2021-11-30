package com.example.jkhproject.data.repositories

import android.util.Log
import com.example.jkhproject.data.api.JkhService
import com.example.jkhproject.data.models.network.NewsNetModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class NewsRepository @Inject constructor(
    private val apiService: JkhService
) {

    suspend fun getNewsList(): List<NewsNetModel> {
        return apiService.getNews()
    }
}
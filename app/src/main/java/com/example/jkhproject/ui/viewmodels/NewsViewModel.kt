package com.example.jkhproject.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jkhproject.data.models.network.NewsNetModel
import com.example.jkhproject.data.repositories.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val _news =
        MutableStateFlow<List<NewsNetModel>>(listOf())
    val news: StateFlow<List<NewsNetModel>> = _news

    init{
        getNews()
    }

    fun getNews(){
        viewModelScope.launch(Dispatchers.IO) {
            _news.value = newsRepository.getNewsList()
        }
    }
}
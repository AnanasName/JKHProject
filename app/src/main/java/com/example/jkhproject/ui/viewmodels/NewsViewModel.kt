package com.example.jkhproject.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.jkhproject.data.repositories.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {
}
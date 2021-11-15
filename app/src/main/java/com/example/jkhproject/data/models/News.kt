package com.example.jkhproject.data.models

import java.util.*

data class News(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val subDescription: String,
    val description: String,
    val date: String
)

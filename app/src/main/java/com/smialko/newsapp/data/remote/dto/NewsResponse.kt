package com.smialko.newsapp.data.remote.dto

import com.smialko.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
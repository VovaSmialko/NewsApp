package com.smialko.newsapp.presentation.bookmark

import com.smialko.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)

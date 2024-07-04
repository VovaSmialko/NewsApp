package com.smialko.newsapp.domain.usecases.news

import com.smialko.newsapp.data.local.NewsDao
import com.smialko.newsapp.domain.model.Article
import com.smialko.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val newsRepository: NewsRepository
) {


    operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticle()
    }
}
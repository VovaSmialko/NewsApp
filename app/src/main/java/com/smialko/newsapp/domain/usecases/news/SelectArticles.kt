package com.smialko.newsapp.domain.usecases.news

import com.smialko.newsapp.data.local.NewsDao
import com.smialko.newsapp.domain.model.Article
import com.smialko.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsRepository: NewsRepository
) {


    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectArticles(url)
    }
}
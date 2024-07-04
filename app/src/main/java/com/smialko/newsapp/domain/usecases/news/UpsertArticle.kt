package com.smialko.newsapp.domain.usecases.news

import com.smialko.newsapp.data.local.NewsDao
import com.smialko.newsapp.domain.model.Article
import com.smialko.newsapp.domain.repository.NewsRepository

class UpsertArticle(
    private val newsRepository: NewsRepository
) {


    suspend operator fun invoke(article: Article) {
        newsRepository.upsertArticle(article)
    }
}
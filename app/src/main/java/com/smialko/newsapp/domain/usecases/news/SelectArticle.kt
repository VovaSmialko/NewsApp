package com.smialko.newsapp.domain.usecases.news

import com.smialko.newsapp.data.local.NewsDao
import com.smialko.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticle(
    private val newsDao: NewsDao
) {


    operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticles()
    }
}
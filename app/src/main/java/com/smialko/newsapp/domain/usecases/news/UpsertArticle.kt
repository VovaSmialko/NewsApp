package com.smialko.newsapp.domain.usecases.news

import com.smialko.newsapp.data.local.NewsDao
import com.smialko.newsapp.domain.model.Article

class UpsertArticle(
    private val newsDao: NewsDao
) {


    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article)
    }
}
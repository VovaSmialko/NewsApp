package com.smialko.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.smialko.newsapp.data.remote.NewsApi
import com.smialko.newsapp.data.remote.dto.NewsPagingSource
import com.smialko.newsapp.domain.model.Article
import com.smialko.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}
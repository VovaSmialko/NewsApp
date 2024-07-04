package com.smialko.newsapp.presentation.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smialko.newsapp.domain.model.Article
import com.smialko.newsapp.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
) : ViewModel() {

    var sideEffect by mutableStateOf<String?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.UpsertDeleteArticle -> {
                viewModelScope.launch {
                    val article = newsUseCases.selectArticles(event.article.url)
                    if (article == null) {
                        upsertArticles(event.article)
                    } else {
                        deleteArticles(event.article)
                    }
                }
            }

            is DetailsEvent.RemoveSideEffect -> {
                sideEffect = null
            }
        }
    }

    private suspend fun deleteArticles(article: Article) {
        newsUseCases.deleteArticle(article = article)
        sideEffect = "Article Deleted"
    }

    private suspend fun upsertArticles(article: Article) {
        newsUseCases.upsertArticle(article = article)
        sideEffect = "Article Saved"
    }
}
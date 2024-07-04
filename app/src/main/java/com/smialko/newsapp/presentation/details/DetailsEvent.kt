package com.smialko.newsapp.presentation.details

import com.smialko.newsapp.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article) : DetailsEvent()

    data object RemoveSideEffect : DetailsEvent()

}
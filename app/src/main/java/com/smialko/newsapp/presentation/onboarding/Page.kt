package com.smialko.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.smialko.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)


val pages = listOf(
    Page(
        title = "What is Lorem Ipsum?",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Why do we use it?",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Where does it come from?",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry",
        image = R.drawable.onboarding3
    )
)

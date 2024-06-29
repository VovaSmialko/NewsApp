package com.smialko.newsapp.presentation.onboarding

sealed class OnBoardingEvent {

    data object SaveAppEntry: OnBoardingEvent()
}
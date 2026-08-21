package com.example.codenox.feature.main.presentation.home.components

sealed interface HomeAction {
    data object OnLearnClick : HomeAction
    data object OnTrophiesClick : HomeAction
    data object OnProfileClick : HomeAction
    data object OnTimerClick : HomeAction
}

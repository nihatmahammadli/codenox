package com.example.codenox.feature.main.presentation.trophies.components

sealed interface TrophiesAction {
    data object OnViewAllBadgesClick : TrophiesAction
}

package com.example.codenox.feature.main.presentation.profile.components

sealed interface ProfileAction {
    data object OnSettingsClick : ProfileAction
    data object OnLearnClick : ProfileAction
    data object OnSavedClick : ProfileAction
}

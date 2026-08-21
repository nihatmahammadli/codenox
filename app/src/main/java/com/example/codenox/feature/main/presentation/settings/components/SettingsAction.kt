package com.example.codenox.feature.main.presentation.settings.components

sealed interface SettingsAction {
    data object OnBackClick : SettingsAction
    data object OnEditNameClick : SettingsAction
    data object OnEditEmailClick : SettingsAction
    data object OnDailyGoalClick : SettingsAction
    data object OnLogoutClick : SettingsAction
    data object OnLanguageClick : SettingsAction
    data object OnThemeClick : SettingsAction
}

package com.example.codenox.feature.main.presentation.settings

import androidx.compose.runtime.Composable
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.feature.main.presentation.settings.components.*

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onEditNameClick: () -> Unit,
    onEditEmailClick: () -> Unit,
    onDailyGoalClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    BaseScreen<SettingsUiState, SettingsViewModel> { uiState, viewModel ->
        SettingsScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    SettingsAction.OnBackClick -> onBackClick()
                    SettingsAction.OnEditNameClick -> onEditNameClick()
                    SettingsAction.OnEditEmailClick -> onEditEmailClick()
                    SettingsAction.OnDailyGoalClick -> onDailyGoalClick()
                    SettingsAction.OnLogoutClick -> onLogoutClick()
                    SettingsAction.OnLanguageClick -> viewModel.showLanguageModal()
                    SettingsAction.OnThemeClick -> viewModel.showThemeModal()
                }
            }
        )

        if (uiState.isThemeModalVisible) {
            ThemeSelectionModal(
                currentTheme = uiState.selectedTheme,
                onDismiss = viewModel::hideThemeModal,
                onThemeApplied = viewModel::onThemeSelected
            )
        }

        if (uiState.isLanguageModalVisible) {
            LanguageSelectionModal(
                currentLanguage = uiState.selectedLanguage,
                onDismiss = viewModel::hideLanguageModal,
                onLanguageApplied = viewModel::onLanguageSelected
            )
        }
    }
}

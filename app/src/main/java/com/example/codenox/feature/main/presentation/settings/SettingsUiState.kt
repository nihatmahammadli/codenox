package com.example.codenox.feature.main.presentation.settings

import com.example.codenox.domain.model.Profile

data class SettingsUiState(
    val profile: Profile? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val isThemeModalVisible: Boolean = false,
    val isLanguageModalVisible: Boolean = false,
    val selectedTheme: ThemeType = ThemeType.DARK,
    val selectedLanguage: LanguageType = LanguageType.ENGLISH
)

enum class ThemeType(val label: String) {
    LIGHT("Light"),
    DARK("Dark"),
    SYSTEM("System")
}

enum class LanguageType(val label: String) {
    TURKISH("Türkçe"),
    ENGLISH("English"),
    GERMAN("Deutsch")
}

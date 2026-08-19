package com.example.codenox.feature.main.presentation.settings

import com.example.codenox.domain.model.Profile

data class SettingsUiState(
    val profile: Profile? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)
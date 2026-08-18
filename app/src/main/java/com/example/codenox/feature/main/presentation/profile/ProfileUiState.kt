package com.example.codenox.feature.main.presentation.profile

import com.example.codenox.domain.model.Profile

data class ProfileUiState(
    val profile: Profile? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)

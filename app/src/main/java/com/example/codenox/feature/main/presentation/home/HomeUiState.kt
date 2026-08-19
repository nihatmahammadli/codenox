package com.example.codenox.feature.main.presentation.home

import com.example.codenox.domain.model.Profile

data class HomeUiState (
    val profile: Profile? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
)
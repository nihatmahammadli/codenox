package com.example.codenox.feature.main.presentation.email

data class AddEmailUiState(
    val email: String = "",
    val isButtonEnabled: Boolean = false,
    val isLoading: Boolean = false
)

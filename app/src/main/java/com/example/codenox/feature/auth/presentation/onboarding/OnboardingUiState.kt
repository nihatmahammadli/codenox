package com.example.codenox.feature.auth.presentation.onboarding

data class OnboardingUiState(
    val name: String = "",
    val nickname: String = "",
    val selectedLevel: Int? = null,
    val currentPage: Int = 0,
    val isButtonEnabled: Boolean = false
)

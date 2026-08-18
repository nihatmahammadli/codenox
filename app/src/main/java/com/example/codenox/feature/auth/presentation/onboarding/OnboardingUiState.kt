package com.example.codenox.feature.auth.presentation.onboarding

import com.example.codenox.domain.model.ExperienceLevel

data class OnboardingUiState(
    val currentStep: Int = 0,
    val fullName: String = "",
    val nickname: String = "",
    val experienceLevel: ExperienceLevel? = null,
    val isLoading: Boolean = false,
    val fullNameError: String? = null,
    val nicknameError: String? = null,
    val errorMessage: String? = null,
    val isButtonEnabled: Boolean = false
)

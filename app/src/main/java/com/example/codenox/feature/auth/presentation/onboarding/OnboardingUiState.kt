package com.example.codenox.feature.auth.presentation.onboarding

import com.example.codenox.domain.model.ExperienceLevel

data class OnboardingUiState(
    val currentStep: Int = 0,
    val totalSteps: Int = 2,
    val fullName: String = "",
    val nickname: String = "",
    val experienceLevel: ExperienceLevel? = null,
    val isButtonEnabled: Boolean = false
)

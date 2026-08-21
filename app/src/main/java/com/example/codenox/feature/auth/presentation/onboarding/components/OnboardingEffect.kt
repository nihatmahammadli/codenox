package com.example.codenox.feature.auth.presentation.onboarding.components

sealed interface OnboardingEffect {

    data object NavigateToHome : OnboardingEffect

    data class ShowError(
        val message: String
    ) : OnboardingEffect
}
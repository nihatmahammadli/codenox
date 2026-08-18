package com.example.codenox.feature.auth.presentation.onboarding

import com.example.codenox.domain.model.ExperienceLevel

sealed interface OnboardingAction {

    data class FullNameChanged(
        val value: String
    ) : OnboardingAction

    data class NicknameChanged(
        val value: String
    ) : OnboardingAction

    data class LevelSelected(
        val level: ExperienceLevel
    ) : OnboardingAction

    data class PageChanged(
        val page: Int
    ) : OnboardingAction

    data object CompleteOnboarding : OnboardingAction
}
package com.example.codenox.feature.auth.presentation.onboarding.components

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.codenox.feature.auth.presentation.onboarding.OnboardingUiState
import com.example.codenox.feature.auth.presentation.onboarding.components.steps.PersonalizeStep
import com.example.codenox.feature.auth.presentation.onboarding.components.steps.SkillLevelStep

@Composable
fun OnboardingPager(
    pagerState: PagerState,
    uiState: OnboardingUiState,
    onAction: (OnboardingAction) -> Unit,
    modifier: Modifier = Modifier
) {
    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        userScrollEnabled = false
    ) { page ->
        when (page) {
            0 -> PersonalizeStep(state = uiState, onAction = onAction)
            1 -> SkillLevelStep(state = uiState, onAction = onAction)
        }
    }
}

package com.example.codenox.feature.auth.presentation.onboarding.components.steps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.domain.model.ExperienceLevel
import com.example.codenox.feature.auth.presentation.onboarding.OnboardingUiState
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingAction
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingLevelCard
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingStepHeader

@Composable
fun SkillLevelStep(
    state: OnboardingUiState,
    onAction: (OnboardingAction) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        OnboardingStepHeader(
            category = "SKILL LEVEL",
            title = "What's your level?",
            description = "We will adjust the starting path and lesson difficulty based on your current experience."
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        OnboardingLevelCard(
            title = "Beginner",
            description = "Just starting out with coding or mobile development",
            icon = R.drawable.ic_star,
            isSelected = state.experienceLevel == ExperienceLevel.BEGINNER,
            onClick = { onAction(OnboardingAction.LevelSelected(ExperienceLevel.BEGINNER)) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OnboardingLevelCard(
            title = "Intermediate",
            description = "Some experience with Kotlin and basic Android concepts",
            icon = R.drawable.ic_learn,
            isSelected = state.experienceLevel == ExperienceLevel.INTERMEDIATE,
            onClick = { onAction(OnboardingAction.LevelSelected(ExperienceLevel.INTERMEDIATE)) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OnboardingLevelCard(
            title = "Advanced",
            description = "Experienced engineer looking to master architecture & compose",
            icon = R.drawable.ic_trophies,
            isSelected = state.experienceLevel == ExperienceLevel.ADVANCED,
            onClick = { onAction(OnboardingAction.LevelSelected(ExperienceLevel.ADVANCED)) }
        )
    }
}

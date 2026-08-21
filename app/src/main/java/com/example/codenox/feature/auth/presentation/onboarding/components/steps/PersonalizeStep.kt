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
import com.example.codenox.core.designsystem.components.CodeNoxTextField
import com.example.codenox.feature.auth.presentation.onboarding.OnboardingUiState
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingAction
import com.example.codenox.feature.auth.presentation.onboarding.components.OnboardingStepHeader

@Composable
fun PersonalizeStep(
    state: OnboardingUiState,
    onAction: (OnboardingAction) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        OnboardingStepHeader(
            category = "PERSONALIZE",
            title = "Tell us about\nyourself",
            description = "We'll use this to customize your learning journey and set up your public developer profile."
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        CodeNoxTextField(
            value = state.fullName,
            onValueChange = { onAction(OnboardingAction.FullNameChanged(it)) },
            label = "Your Name",
            placeholder = "Your Full Name here"
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        CodeNoxTextField(
            value = state.nickname,
            onValueChange = { onAction(OnboardingAction.NicknameChanged(it)) },
            label = "@nickname",
            placeholder = "Nickname here"
        )
    }
}

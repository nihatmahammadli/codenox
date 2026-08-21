package com.example.codenox.feature.auth.presentation.onboarding.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxButton

@Composable
fun OnboardingBottomSection(
    currentStep: Int,
    stepCount: Int,
    isButtonEnabled: Boolean,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val isLastStep = currentStep == stepCount - 1
    
    CodeNoxButton(
        text = if (isLastStep) "Start Learning" else "Continue",
        enabled = isButtonEnabled,
        onClick = onNextClick,
        modifier = modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.Black
            )
        }
    )
}

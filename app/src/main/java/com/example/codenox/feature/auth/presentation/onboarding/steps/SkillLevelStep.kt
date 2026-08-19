package com.example.codenox.feature.auth.presentation.onboarding.steps

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.ExperienceLevel
import com.example.codenox.feature.auth.presentation.onboarding.OnboardingAction
import com.example.codenox.feature.auth.presentation.onboarding.OnboardingUiState

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
        Text(
            text = "SKILL LEVEL",
            style = CodeNoxTheme.typography.dmSans12Bold,
            color = CodeNoxTheme.colors.primary,
            letterSpacing = 2.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "What's your level?",
            style = CodeNoxTheme.typography.dmSans36Bold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "We will adjust the starting path and lesson difficulty based on your current experience.",
            style = CodeNoxTheme.typography.dmSans14Regular,
            color = CodeNoxTheme.colors.textSecondary
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        LevelCard(
            title = "Beginner",
            description = "Just starting out with coding or mobile development",
            icon = R.drawable.ic_star,
            isSelected = state.experienceLevel == ExperienceLevel.BEGINNER,
            onClick = { onAction(
                OnboardingAction.LevelSelected(ExperienceLevel.BEGINNER)
            ) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        LevelCard(
            title = "Intermediate",
            description = "Some experience with Kotlin and basic Android concepts",
            icon = R.drawable.ic_learn,
            isSelected = state.experienceLevel == ExperienceLevel.INTERMEDIATE,
            onClick = { onAction (
                OnboardingAction.LevelSelected(ExperienceLevel.INTERMEDIATE)
            ) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        LevelCard(
            title = "Advanced",
            description = "Experienced engineer looking to master architecture & compose",
            icon = R.drawable.ic_trophies,
            isSelected = state.experienceLevel == ExperienceLevel.ADVANCED,
            onClick = {
                onAction (
                    OnboardingAction.LevelSelected(ExperienceLevel.ADVANCED)
                )
            }
        )
    }
}

@Composable
private fun LevelCard(
    title: String,
    description: String,
    icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .background(
                color = if (isSelected) Color(0xFF162018) else Color(0xFF121614),
                shape = RoundedCornerShape(20.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) CodeNoxTheme.colors.primary else Color.White.copy(alpha = 0.05f),
                shape = RoundedCornerShape(20.dp)
            )
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = if (isSelected) CodeNoxTheme.colors.primary.copy(alpha = 0.1f) else Color.White.copy(alpha = 0.05f),
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint = if (isSelected) CodeNoxTheme.colors.primary else CodeNoxTheme.colors.textSecondary
            )
        }
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column {
            Text(
                text = title,
                style = CodeNoxTheme.typography.dmSans16Bold,
                color = Color.White
            )
            Text(
                text = description,
                style = CodeNoxTheme.typography.dmSans12Regular,
                color = CodeNoxTheme.colors.textSecondary
            )
        }
    }
}

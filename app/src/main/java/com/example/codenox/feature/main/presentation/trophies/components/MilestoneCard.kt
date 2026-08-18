package com.example.codenox.feature.main.presentation.trophies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.Milestone

@Composable
fun MilestoneCard(milestone: Milestone) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(CodeNoxTheme.colors.surface)
            .padding(24.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                text = "NEXT MILESTONE",
                style = CodeNoxTheme.typography.dmSans12Bold,
                color = CodeNoxTheme.colors.textSecondary
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = milestone.title,
                    style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                    color = CodeNoxTheme.colors.textPrimary
                )
                Text(
                    text = "${milestone.currentXp} / ${milestone.targetXp} XP",
                    style = CodeNoxTheme.typography.jetBrainsMono12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
            }

            // Progress Bar
            val progress = milestone.currentXp.toFloat() / milestone.targetXp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(CodeNoxTheme.colors.background)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(progress)
                        .fillMaxHeight()
                        .background(CodeNoxTheme.colors.primary)
                )
            }
        }
    }
}

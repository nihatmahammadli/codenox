package com.example.codenox.feature.learn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.LearningPath

@Composable
fun LearningPathCard(
    path: LearningPath,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(CodeNoxTheme.colors.surface)
            .clickable(onClick = onClick)
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Path Icon
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .background(CodeNoxTheme.colors.background.copy(alpha = 0.5f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                 androidx.compose.material3.Icon(
                    painter = painterResource(id = path.iconRes ?: R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(28.dp)
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = path.title,
                    style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                    color = CodeNoxTheme.colors.textPrimary
                )
                
                if (path.completedLessons > 0) {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        val progress = path.completedLessons.toFloat() / path.totalLessons
                        
                        // Custom Progress Bar to avoid LinearProgressIndicator glitches
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp))
                                .background(CodeNoxTheme.colors.background)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(progress)
                                    .fillMaxHeight()
                                    .background(CodeNoxTheme.colors.primary, RoundedCornerShape(3.dp))
                            )
                        }

                        Text(
                            text = "${path.completedLessons} of ${path.totalLessons} lessons completed",
                            style = CodeNoxTheme.typography.dmSans12Regular,
                            color = CodeNoxTheme.colors.textSecondary
                        )
                    }
                }
else {
                    Text(
                        text = "${path.totalLessons} lessons • ${path.level ?: "Beginner"}",
                        style = CodeNoxTheme.typography.dmSans12Regular,
                        color = CodeNoxTheme.colors.textSecondary
                    )
                }
            }
        }
    }
}

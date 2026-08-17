package com.example.codenox.feature.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.Lesson

@Composable
fun ActiveLessonCard(
    lesson: Lesson,
    onContinueClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = CodeNoxTheme.colors.surface
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Category, Time and XP
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${lesson.index}. ${lesson.category}",
                    style = CodeNoxTheme.typography.dmSans14Bold,
                    color = CodeNoxTheme.colors.primary
                )
                
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Time
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_time),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.Unspecified // Keep original icon colors
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = lesson.duration,
                            style = CodeNoxTheme.typography.dmSans12Regular,
                            color = CodeNoxTheme.colors.textSecondary
                        )
                    }
                    
                    // XP
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.Unspecified // Keep original icon colors
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "+${lesson.xp} XP",
                            style = CodeNoxTheme.typography.dmSans12Regular,
                            color = CodeNoxTheme.colors.textSecondary
                        )
                    }
                }
            }

            // Title
            Text(
                text = lesson.title,
                style = CodeNoxTheme.typography.jetBrainsMono24Bold,
                color = CodeNoxTheme.colors.textPrimary
            )

            // Description
            Text(
                text = lesson.description,
                style = CodeNoxTheme.typography.dmSans14Regular,
                color = CodeNoxTheme.colors.textSecondary,
                lineHeight = 20.sp
            )

            // Continue Button
            Button(
                onClick = onContinueClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = CodeNoxTheme.colors.primary,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(28.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Continue Learning",
                        style = CodeNoxTheme.typography.dmSans16Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified // Keep original icon colors
                    )
                }
            }
        }
    }
}

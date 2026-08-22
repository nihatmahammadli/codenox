package com.example.codenox.feature.main.presentation.learn.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.common.glowCardBackground
import com.example.codenox.core.designsystem.model.GlowPosition
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.ContinueLearning

@Composable
fun ContinueLearningCard(
    data: ContinueLearning,
    onResumeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .glowCardBackground(
                backgroundColor = CodeNoxTheme.colors.surface,
                glowColor = CodeNoxTheme.colors.primary,
                glowAlpha = 0.12f,
                glowPosition = GlowPosition.TopEnd
            )
            .padding(24.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_active_lesson),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "NEXT: LESSON ${data.lessonNumber}",
                    style = CodeNoxTheme.typography.jetBrainsMono14Bold,
                    color = CodeNoxTheme.colors.primary
                )
            }

            Text(
                text = data.title,
                style = CodeNoxTheme.typography.jetBrainsMono24Bold,
                color = CodeNoxTheme.colors.textPrimary
            )

            Text(
                text = data.description,
                style = CodeNoxTheme.typography.dmSans14Regular,
                color = CodeNoxTheme.colors.textSecondary,
                lineHeight = 20.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    InfoItem(icon = R.drawable.ic_time, text = data.duration)
                    InfoItem(icon = R.drawable.ic_launcher_foreground, text = data.level)
                }

                Row(
                    modifier = Modifier.clickable(onClick = onResumeClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Resume",
                        style = CodeNoxTheme.typography.dmSans16Bold,
                        color = CodeNoxTheme.colors.primary,
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right_small),
                        contentDescription = null,
                        tint = CodeNoxTheme.colors.primary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun InfoItem(icon: Int, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = CodeNoxTheme.colors.textSecondary,
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            style = CodeNoxTheme.typography.dmSans12Regular,
            color = CodeNoxTheme.colors.textSecondary
        )
    }
}

package com.example.codenox.feature.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.common.glowCardBackground
import com.example.codenox.core.designsystem.model.GlowPosition
import com.example.codenox.core.designsystem.theme.CodeNoxGold
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun StreakCard(
    onStreakClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    streakDays: String = "0",
    milestoneText: String = "Complete a lesson to start your streak"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(190.dp)
            .glowCardBackground(
                backgroundColor = CodeNoxTheme.colors.surface,
                glowColor = CodeNoxGold,
                glowAlpha = 0.14f,
                glowPosition = GlowPosition.TopEnd
            )
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = onStreakClick)
            .padding(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.ic_daily_streak),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = Color.Unspecified
                )

                Spacer(modifier = Modifier.padding(start = 12.dp))

                Text(
                    text = "STREAK",
                    style = CodeNoxTheme.typography.dmSans14Bold,
                    color = CodeNoxTheme.colors.secondary
                )
            }
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = streakDays,
                    style = CodeNoxTheme.typography.jetBrainsMono36Bold,
                    color = CodeNoxTheme.colors.textPrimary
                )
                Text(
                    text = "d",
                    style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                    color = CodeNoxTheme.colors.textSecondary,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
            }
            Text(
                text = milestoneText,
                style = CodeNoxTheme.typography.dmSans14Regular,
                color = CodeNoxTheme.colors.textSecondary
            )
        }
    }
}

package com.example.codenox.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.common.glowCardBackground
import com.example.codenox.core.designsystem.components.SegmentedCircularProgressIndicator
import com.example.codenox.core.designsystem.model.GlowPosition
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun DailyGoalCard(
    modifier: Modifier = Modifier,
    goalTime: String = "0/60m",
    progress: Float = 0f
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(190.dp)
            .glowCardBackground(
                backgroundColor = CodeNoxTheme.colors.surface,
                glowColor = CodeNoxTheme.colors.greenAlpha10,
                glowAlpha = 0.14f,
                glowPosition = GlowPosition.BottomStart
            )
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "GOAL",
                    color = CodeNoxTheme.colors.primary,
                    style = CodeNoxTheme.typography.dmSans14Bold
                )

                Text(
                    text = goalTime,
                    color = CodeNoxTheme.colors.textSecondary,
                    style = CodeNoxTheme.typography.dmSans14Regular
                )
            }
            
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                SegmentedCircularProgressIndicator(
                    progress = progress,
                    size = 90.dp,
                    strokeWidth = 6.dp
                )
            }
        }
    }
}

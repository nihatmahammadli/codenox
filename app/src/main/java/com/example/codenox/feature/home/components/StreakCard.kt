package com.example.codenox.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.common.glowCardBackground
import com.example.codenox.core.designsystem.model.GlowPosition
import com.example.codenox.core.designsystem.theme.CodeNoxGold
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun StreakCard(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
                .glowCardBackground(
                backgroundColor = CodeNoxTheme.colors.surface,
                glowColor = CodeNoxGold,
                glowAlpha = 0.14f,
                glowPosition = GlowPosition.TopEnd
            )
            .padding(20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.ic_daily_streak),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
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
                    text = "12",
                    style = CodeNoxTheme.typography.mono36Bold,
                    color = CodeNoxTheme.colors.textPrimary
                )
                Text(
                    text = "d",
                    style = CodeNoxTheme.typography.mono18Bold,
                    color = CodeNoxTheme.colors.textSecondary,
                    modifier = Modifier.padding(bottom = 6.dp)
                )
            }
            Text(
                text = "3 days to next\nmilestone",
                style = CodeNoxTheme.typography.dmSans16Regular,
                color = CodeNoxTheme.colors.textSecondary
            )
        }
    }
}

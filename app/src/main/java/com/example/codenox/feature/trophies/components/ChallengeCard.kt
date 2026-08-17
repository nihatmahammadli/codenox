package com.example.codenox.feature.trophies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.Challenge

@Composable
fun ChallengeCard(challenge: Challenge) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(CodeNoxTheme.colors.surface)
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Challenge Icon
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(CodeNoxTheme.colors.secondary.copy(alpha = 0.1f), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // Placeholder
                    contentDescription = null,
                    tint = CodeNoxTheme.colors.secondary,
                    modifier = Modifier.size(24.dp)
                )
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = challenge.title,
                    style = CodeNoxTheme.typography.jetBrainsMono16Bold,
                    color = CodeNoxTheme.colors.textPrimary
                )
                Text(
                    text = challenge.description,
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
            }

            Text(
                text = "${challenge.currentProgress}/${challenge.totalGoal}",
                style = CodeNoxTheme.typography.jetBrainsMono16Bold,
                color = CodeNoxTheme.colors.secondary
            )
        }
    }
}

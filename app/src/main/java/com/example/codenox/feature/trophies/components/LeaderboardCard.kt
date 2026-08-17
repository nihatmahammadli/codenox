package com.example.codenox.feature.trophies.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.LeaderboardEntry

@Composable
fun LeaderboardCard(entries: List<LeaderboardEntry>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(CodeNoxTheme.colors.surface)
    ) {
        entries.forEach { entry ->
            LeaderboardRow(entry)
        }
    }
}

@Composable
private fun LeaderboardRow(entry: LeaderboardEntry) {
    val backgroundColor = if (entry.isCurrentUser) {
        CodeNoxTheme.colors.primary.copy(alpha = 0.1f)
    } else {
        Color.Transparent
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "${entry.rank}",
            style = CodeNoxTheme.typography.dmSans14Bold,
            color = if (entry.rank == 1) CodeNoxTheme.colors.secondary else CodeNoxTheme.colors.textSecondary,
            modifier = Modifier.width(24.dp)
        )
        
        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_default_profile),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = entry.name,
            style = CodeNoxTheme.typography.jetBrainsMono16Bold,
            color = if (entry.isCurrentUser) CodeNoxTheme.colors.primary else CodeNoxTheme.colors.textPrimary,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "${entry.xp} XP",
            style = CodeNoxTheme.typography.jetBrainsMono12Regular,
            color = CodeNoxTheme.colors.textSecondary
        )
    }
}

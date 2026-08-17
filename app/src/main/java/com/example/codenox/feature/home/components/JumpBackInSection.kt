package com.example.codenox.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import com.example.codenox.domain.model.HistoryItem

@Composable
fun JumpBackInSection(
    historyItems: List<HistoryItem>,
    onItemClick: (HistoryItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "JUMP BACK IN",
            style = CodeNoxTheme.typography.jetBrainsMono18Bold,
            color = CodeNoxTheme.colors.textSecondary
        )

        if (historyItems.isEmpty()) {
            EmptyHistoryPlaceholder()
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(end = 16.dp)
            ) {
                items(historyItems) { item ->
                    JumpBackInCard(
                        item = item,
                        onClick = { onItemClick(item) }
                    )
                }
            }
        }
    }
}

@Composable
private fun JumpBackInCard(
    item: HistoryItem,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(240.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(CodeNoxTheme.colors.surface)
            .clickable(onClick = onClick)
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            // Icon
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(CodeNoxTheme.colors.background.copy(alpha = 0.5f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = item.iconRes ?: R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    tint = CodeNoxTheme.colors.primary,
                    modifier = Modifier.size(18.dp)
                )
            }

            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = item.title,
                    style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                    color = CodeNoxTheme.colors.textPrimary,
                    maxLines = 1
                )
                
                val subtitle = if (item.duration != null) {
                    "${item.type} • ${item.duration}"
                } else {
                    item.type
                }
                
                Text(
                    text = subtitle,
                    style = CodeNoxTheme.typography.dmSans14Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
            }
        }
    }
}

@Composable
private fun EmptyHistoryPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(CodeNoxTheme.colors.surface.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No recent activity yet. Start a lesson!",
            style = CodeNoxTheme.typography.dmSans14Medium,
            color = CodeNoxTheme.colors.textSecondary
        )
    }
}

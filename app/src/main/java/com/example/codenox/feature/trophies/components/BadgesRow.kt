package com.example.codenox.feature.trophies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.Badge

@Composable
fun BadgesRow(badges: List<Badge>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        badges.forEach { badge ->
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        if (badge.isLocked) CodeNoxTheme.colors.surface.copy(alpha = 0.5f) 
                        else CodeNoxTheme.colors.surface, 
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (badge.isLocked) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_deactive_lesson),
                        contentDescription = null,
                        tint = CodeNoxTheme.colors.textSecondary,
                        modifier = Modifier.size(24.dp)
                    )
                } else if (badge.isNew) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_active_lesson),
                        contentDescription = null,
                        tint = CodeNoxTheme.colors.secondary,
                        modifier = Modifier.size(28.dp)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(CodeNoxTheme.colors.primary.copy(alpha = 0.2f), CircleShape)
                    )
                }
            }
        }
    }
}

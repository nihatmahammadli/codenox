package com.example.codenox.feature.main.presentation.trophies.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.UserTrophyInfo

@Composable
fun TrophyHeader(info: UserTrophyInfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        // Main Badge with Level
        Box(contentAlignment = Alignment.BottomEnd) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(CodeNoxTheme.colors.primary.copy(alpha = 0.1f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_trophies),
                    contentDescription = null,
                    tint = CodeNoxTheme.colors.primary,
                    modifier = Modifier.size(50.dp)
                )
            }
            
            // Level Bubble
            Box(
                modifier = Modifier
                    .size(28.dp)
                    .background(CodeNoxTheme.colors.primary, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${info.level}",
                    style = CodeNoxTheme.typography.dmSans12Bold,
                    color = Color.Black
                )
            }
        }

        // XP Text
        Row(verticalAlignment = Alignment.Bottom) {
            Text(
                text = info.totalXp,
                style = CodeNoxTheme.typography.jetBrainsMono36Bold,
                color = CodeNoxTheme.colors.textPrimary
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "XP",
                style = CodeNoxTheme.typography.dmSans16Bold,
                color = CodeNoxTheme.colors.primary,
                modifier = Modifier.padding(bottom = 6.dp)
            )
        }

        Text(
            text = "LEVEL ${info.level} DEVELOPER",
            style = CodeNoxTheme.typography.jetBrainsMono14Bold,
            color = CodeNoxTheme.colors.textSecondary
        )
    }
}

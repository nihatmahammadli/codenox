package com.example.codenox.feature.main.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LearningProgressSection(onClick: () -> Unit) {
    Column {
        Text(
            text = "LEARNING PROGRESS",
            style = CodeNoxTheme.typography.dmSans12Bold,
            color = CodeNoxTheme.colors.textSecondary,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFF121614))
                .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                .clickable(onClick = onClick)
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "MODULE 1 • KOTLIN BASICS",
                        style = CodeNoxTheme.typography.dmSans12Bold,
                        color = CodeNoxTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Getting Started",
                        style = CodeNoxTheme.typography.dmSans18Bold,
                        color = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .background(CodeNoxTheme.colors.primary.copy(alpha = 0.1f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "0%",
                        style = CodeNoxTheme.typography.dmSans12Bold,
                        color = CodeNoxTheme.colors.primary
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            LinearProgressIndicator(
                progress = { 0f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(CircleShape),
                color = CodeNoxTheme.colors.primary,
                trackColor = Color(0xFF1A1F1C),
                drawStopIndicator = {}
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "0 of 10 lessons completed in this path.",
                style = CodeNoxTheme.typography.dmSans12Regular,
                color = CodeNoxTheme.colors.textSecondary
            )
        }
    }
}

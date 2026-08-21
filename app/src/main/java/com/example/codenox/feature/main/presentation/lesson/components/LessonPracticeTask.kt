package com.example.codenox.feature.main.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LessonPracticeTask(
    title: String,
    level: String,
    duration: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(CodeNoxTheme.colors.surface, RoundedCornerShape(24.dp))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .border(1.dp, Color(0xFFFFA500), RoundedCornerShape(12.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
                Text(
                    text = level,
                    style = CodeNoxTheme.typography.dmSans12Bold,
                    color = Color(0xFFFFA500)
                )
            }
            
            Text(
                text = "~$duration",
                style = CodeNoxTheme.typography.dmSans12Regular,
                color = CodeNoxTheme.colors.textSecondary
            )
        }
        
        Text(
            text = title,
            style = CodeNoxTheme.typography.jetBrainsMono18Bold,
            color = Color.White
        )
        
        Text(
            text = description,
            style = CodeNoxTheme.typography.dmSans14Regular,
            color = CodeNoxTheme.colors.textSecondary,
            lineHeight = 20.sp
        )
    }
}

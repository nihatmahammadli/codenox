package com.example.codenox.feature.main.presentation.saved.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.SavedLesson

@Composable
fun SavedLessonCard(
    lesson: SavedLesson,
    onBookmarkClick: () -> Unit,
    onStartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(CodeNoxTheme.colors.surface, RoundedCornerShape(24.dp))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // Header: Lesson Tag and Bookmark
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(CodeNoxTheme.colors.darkGreen, CircleShape)
                        .border(1.dp, CodeNoxTheme.colors.primary, CircleShape)
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "LESSON ${lesson.lessonNumber}",
                        style = CodeNoxTheme.typography.dmSans12Bold,
                        color = CodeNoxTheme.colors.primary
                    )
                }

                Icon(
                    painter = painterResource(id = R.drawable.ic_save),
                    contentDescription = "Remove from saved",
                    tint = CodeNoxTheme.colors.primary,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(onClick = onBookmarkClick)
                )
            }

            // Title and Description
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = lesson.title,
                    style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                    color = Color.White
                )
                Text(
                    text = lesson.description,
                    style = CodeNoxTheme.typography.dmSans14Regular,
                    color = CodeNoxTheme.colors.textSecondary,
                    lineHeight = 20.sp
                )
            }

            // Progress Section
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = if (lesson.progress >= 100) "Fully Completed" else "Progress: ${lesson.progress}%",
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
                LinearProgressIndicator(
                    progress = { lesson.progress / 100f },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .clip(CircleShape),
                    color = CodeNoxTheme.colors.primary,
                    trackColor = Color.White.copy(alpha = 0.1f),
                    strokeCap = StrokeCap.Round,
                    drawStopIndicator = {},
                    gapSize = 0.dp
                )
            }

            // Footer: Level and Start
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White.copy(alpha = 0.05f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = lesson.level,
                        style = CodeNoxTheme.typography.dmSans12Bold,
                        color = CodeNoxTheme.colors.textSecondary
                    )
                }

                Row(
                    modifier = Modifier.clickable(onClick = onStartClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Start",
                        style = CodeNoxTheme.typography.dmSans14Bold,
                        color = CodeNoxTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = CodeNoxTheme.colors.primary,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}

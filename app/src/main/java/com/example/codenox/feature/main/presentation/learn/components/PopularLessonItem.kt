package com.example.codenox.feature.main.presentation.learn.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.PopularLesson

@Composable
fun PopularLessonItem(
    lesson: PopularLesson,
    onClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = lesson.title,
                style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                color = CodeNoxTheme.colors.textPrimary
            )
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = lesson.level,
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
                Text(
                    text = "•",
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
                Text(
                    text = lesson.duration,
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
                Text(
                    text = "•",
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
                Text(
                    text = "+${lesson.xp} XP",
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
            }
        }

        Icon(
            painter = painterResource(id = R.drawable.ic_save),
            contentDescription = null,
            tint = if (lesson.isBookmarked) CodeNoxTheme.colors.primary else CodeNoxTheme.colors.textSecondary,
            modifier = Modifier
                .size(24.dp)
                .clickable(onClick = onBookmarkClick)
        )
    }
}

package com.example.codenox.feature.main.presentation.lesson.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LessonTitle(
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
                .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = CodeNoxTheme.colors.textPrimary,
            style = CodeNoxTheme.typography.dmSans24Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = description,
            color = CodeNoxTheme.colors.textSecondary,
            style = CodeNoxTheme.typography.dmSans14Regular
        )
    }
}
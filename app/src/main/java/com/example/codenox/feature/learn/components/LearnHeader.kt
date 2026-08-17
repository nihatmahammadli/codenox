package com.example.codenox.feature.learn.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LearnHeader(
    modifier: Modifier = Modifier,
    headerText: String = "Learn Android"
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = headerText,
            color = CodeNoxTheme.colors.textPrimary,
            style = CodeNoxTheme.typography.jetBrainsMono24Bold
        )
    }
}
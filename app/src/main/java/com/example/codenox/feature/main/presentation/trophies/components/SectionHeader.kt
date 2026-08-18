package com.example.codenox.feature.main.presentation.trophies.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun SectionHeader(
    title: String,
    actionText: String? = null,
    onActionClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = CodeNoxTheme.typography.jetBrainsMono18Bold,
            color = CodeNoxTheme.colors.textSecondary
        )
        if (actionText != null) {
            Text(
                text = actionText,
                style = CodeNoxTheme.typography.dmSans14Bold,
                color = CodeNoxTheme.colors.primary,
                modifier = Modifier.clickable { onActionClick?.invoke() }
            )
        }
    }
}

package com.example.codenox.feature.main.presentation.settings.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun SettingsSectionTitle(title: String) {
    Text(
        text = title,
        style = CodeNoxTheme.typography.dmSans12Bold,
        color = CodeNoxTheme.colors.textSecondary,
        modifier = Modifier.padding(start = 4.dp, bottom = 12.dp),
        letterSpacing = 1.sp
    )
}
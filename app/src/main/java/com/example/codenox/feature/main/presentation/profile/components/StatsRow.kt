package com.example.codenox.feature.main.presentation.profile.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun StatsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        StatCard(
            value = "0",
            label = "Courses Done",
            modifier = Modifier.weight(1f)
        )
        StatCard(
            value = "0",
            label = "Achievements",
            modifier = Modifier.weight(1f)
        )
        StatCard(
            value = "0",
            label = "Day Streak",
            valueColor = CodeNoxTheme.colors.primary,
            modifier = Modifier.weight(1f)
        )
    }
}

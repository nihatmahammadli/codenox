package com.example.codenox.feature.main.presentation.profile.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun RecentActivitySection() {
    Column {
        Text(
            text = "RECENT ACTIVITY",
            style = CodeNoxTheme.typography.dmSans12Bold,
            color = CodeNoxTheme.colors.textSecondary,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No recent activity yet.",
                style = CodeNoxTheme.typography.dmSans14Regular,
                color = CodeNoxTheme.colors.textSecondary.copy(alpha = 0.6f)
            )
        }
    }
}

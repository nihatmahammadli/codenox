package com.example.codenox.feature.main.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun StatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    valueColor: Color = Color.White
) {
    Column(
        modifier = modifier
            .height(100.dp)
            .background(Color(0xFF121614), RoundedCornerShape(20.dp))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(20.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = value,
            style = CodeNoxTheme.typography.dmSans24Bold,
            color = valueColor
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = CodeNoxTheme.typography.dmSans12Regular,
            color = CodeNoxTheme.colors.textSecondary
        )
    }
}

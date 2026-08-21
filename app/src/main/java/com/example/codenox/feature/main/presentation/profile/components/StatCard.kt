package com.example.codenox.feature.main.presentation.profile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun StatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    valueColor: Color = Color.White,
    onClick: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF121614))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(20.dp))
            .then(
                if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier
            )
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = CodeNoxTheme.typography.dmSans24Bold,
            color = valueColor,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = CodeNoxTheme.typography.dmSans12Regular,
            color = CodeNoxTheme.colors.textSecondary,
            textAlign = TextAlign.Center
        )
    }
}

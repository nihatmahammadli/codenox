package com.example.codenox.feature.main.presentation.timer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun TimerConfigRow(
    label: String,
    value: Int,
    onDecrease: () -> Unit,
    onIncrease: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(CodeNoxTheme.colors.surface, RoundedCornerShape(16.dp))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(16.dp))
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = CodeNoxTheme.typography.dmSans14Regular,
            color = CodeNoxTheme.colors.textSecondary
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ConfigButton(icon = R.drawable.ic_minus, onClick = onDecrease)
            
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = value.toString(),
                    style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                    color = Color.White
                )
                Text(
                    text = "min",
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
            }

            ConfigButton(icon = R.drawable.ic_plus, onClick = onIncrease)
        }
    }
}

@Composable
private fun ConfigButton(icon: Int, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(28.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.fillMaxSize()
        )
    }
}

package com.example.codenox.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun OnboardingProgressBar(
    stepCount: Int,
    currentStep: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(stepCount) { index ->
            val isSelected = index == currentStep
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .width(if (isSelected) 24.dp else 8.dp)
                    .height(6.dp)
                    .background(
                        color = if (isSelected) CodeNoxTheme.colors.primary else Color(0xFF1A1F1C),
                        shape = RoundedCornerShape(3.dp)
                    )
            )
        }
    }
}

package com.example.codenox.core.designsystem.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object CodeNoxGradients {
    val GreenGlow = Brush.verticalGradient(
        colors = listOf(
            CodeNoxGreen.copy(alpha = 0.15f),
            Color.Transparent
        )
    )

    val GoldGlow = Brush.verticalGradient(
        colors = listOf(
            CodeNoxGold.copy(alpha = 0.15f),
            Color.Transparent
        )
    )

    val CardGreenGlow = Brush.radialGradient(
        colors = listOf(
            CodeNoxGreen.copy(alpha = 0.12f),
            Color.Transparent
        )
    )

    val CardGoldGlow = Brush.radialGradient(
        colors = listOf(
            CodeNoxGold.copy(alpha = 0.12f),
            Color.Transparent
        )
    )
}

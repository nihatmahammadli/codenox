package com.example.codenox.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// Brand
val CodeNoxGreen = Color(0xFF82D64A)
val CodeNoxGold = Color(0xFFE69924)
val CodeNoxDarkGreen = Color(0xFF091F00)

// Background
val BackgroundPrimary = Color(0xFF0B0D0C)
val BackgroundSecondary = Color(0xFF121614)

// Text
val TextPrimary = Color(0xFFEBF1EC)
val TextSecondary = Color(0xFF7A877E)

// Border
val BorderPrimary = Color(0xFF121614)
val BorderSecondary = Color(0xFF232925)

@Immutable
data class CodeNoxColors(
    val primary: Color = CodeNoxGreen,
    val secondary: Color = CodeNoxGold,
    val tertiary: Color = CodeNoxDarkGreen,
    val background: Color = BackgroundPrimary,
    val surface: Color = BackgroundSecondary,
    val textPrimary: Color = TextPrimary,
    val textSecondary: Color = TextSecondary,
    val border: Color = BorderPrimary,
    val greenAlpha05: Color = CodeNoxGreen.copy(alpha = 0.05f),
    val greenAlpha10: Color = CodeNoxGreen.copy(alpha = 0.10f),
    val greenAlpha15: Color = CodeNoxGreen.copy(alpha = 0.15f),
    val goldAlpha10: Color = CodeNoxGold.copy(alpha = 0.10f),
    val goldAlpha20: Color = CodeNoxGold.copy(alpha = 0.20f),
    val borderSecondary: Color = BorderSecondary,
    val darkGreen : Color = Color(0xFF122215)
)

val LocalCodeNoxColors = staticCompositionLocalOf { CodeNoxColors() }

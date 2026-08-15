package com.example.codenox.core.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class CodeNoxShapes(
    val extraSmall: Shape = RoundedCornerShape(6.dp),
    val small: Shape = RoundedCornerShape(10.dp),
    val medium: Shape = RoundedCornerShape(20.dp),
    val large: Shape = RoundedCornerShape(24.dp),
    val extraLarge: Shape = RoundedCornerShape(28.dp)
)

val LocalCodeNoxShapes = staticCompositionLocalOf { CodeNoxShapes() }

// Material 3 Shapes mapping
val MaterialShapes = androidx.compose.material3.Shapes(
    extraSmall = RoundedCornerShape(6.dp),
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(20.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

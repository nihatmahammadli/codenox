package com.example.codenox.core.common

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.model.GlowPosition

// Extension functions

fun Modifier.glowCardBackground(
    backgroundColor: Color,
    glowColor: Color,
    glowAlpha: Float = 0.14f,
    glowPosition: GlowPosition = GlowPosition.TopEnd
): Modifier = this.drawWithCache {

    val center = when (glowPosition) {
        GlowPosition.TopStart ->
            Offset(size.width * 0.2f, size.height * 0.2f)

        GlowPosition.TopEnd ->
            Offset(size.width * 0.8f, size.height * 0.2f)

        GlowPosition.Center ->
            Offset(size.width * 0.5f, size.height * 0.5f)

        GlowPosition.CenterEnd ->
            Offset(size.width * 0.8f, size.height * 0.5f)

        GlowPosition.BottomStart ->
            Offset(size.width * 0.2f, size.height * 0.8f)
    }

    val glowBrush = Brush.radialGradient(
        colors = listOf(
            glowColor.copy(alpha = glowAlpha),
            Color.Transparent
        ),
        center = center,
        radius = size.maxDimension * 0.8f
    )

    onDrawBehind {

        drawRoundRect(
            color = backgroundColor,
            cornerRadius = CornerRadius(
                28.dp.toPx(),
                28.dp.toPx()
            )
        )

        drawRoundRect(
            brush = glowBrush,
            cornerRadius = CornerRadius(
                28.dp.toPx(),
                28.dp.toPx()
            )
        )
    }
}
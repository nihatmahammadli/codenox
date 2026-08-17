package com.example.codenox.core.designsystem.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun CodeNoxLogo(
    modifier: Modifier = Modifier,
    color: Color = Color.White
) {
    Canvas(modifier = modifier) {
        val strokeWidth = 2.5.dp.toPx()
        val radius = 4.5.dp.toPx()
        
        // Top Left Circle
        val topLeft = Offset(size.width * 0.3f, size.height * 0.3f)
        drawCircle(
            color = color,
            radius = radius,
            center = topLeft,
            style = Stroke(width = strokeWidth)
        )
        
        // Top Right Circle
        val topRight = Offset(size.width * 0.7f, size.height * 0.3f)
        drawCircle(
            color = color,
            radius = radius,
            center = topRight,
            style = Stroke(width = strokeWidth)
        )
        
        // Bottom Center Circle
        val bottomCenter = Offset(size.width * 0.5f, size.height * 0.7f)
        drawCircle(
            color = color,
            radius = radius,
            center = bottomCenter,
            style = Stroke(width = strokeWidth)
        )
        
        // Connection points
        val topMid = Offset(size.width * 0.5f, size.height * 0.3f)
        
        // Horizontal Line between top circles
        drawLine(
            color = color,
            start = Offset(topLeft.x + radius, topLeft.y),
            end = Offset(topRight.x - radius, topRight.y),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
        
        // Vertical Line to bottom circle
        drawLine(
            color = color,
            start = topMid,
            end = Offset(bottomCenter.x, bottomCenter.y - radius),
            strokeWidth = strokeWidth,
            cap = StrokeCap.Round
        )
    }
}

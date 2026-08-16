package com.example.codenox.core.designsystem.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun SegmentedCircularProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    size: Dp = 100.dp,
    strokeWidth: Dp = 8.dp,
    activeColor: Color = CodeNoxTheme.colors.primary,
    segmentCount: Int = 6
) {
    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(size)) {
            val sweep = 360f / segmentCount
            val gap = 15f // degrees

            for (i in 0 until segmentCount) {
                val startAngle = i * sweep + gap / 2f - 90f
                val sweepAngle = sweep - gap
                
                val isActive = (i + 1).toFloat() / segmentCount <= progress

                drawArc(
                    color = if (isActive) activeColor else Color(0xFF1A1D1B),
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(
                        width = strokeWidth.toPx(),
                        cap = StrokeCap.Round
                    )
                )
            }
        }
        
        // Center Target
        Box(
            modifier = Modifier
                .size(size / 3f)
                .background(activeColor.copy(alpha = 0.15f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(size / 6f)) {
                // Use this.size to access DrawScope.size and avoid shadowing
                val drawWidth = this.size.width
                val drawHeight = this.size.height
                val centerX = drawWidth / 2
                val centerY = drawHeight / 2
                val lineLength = drawWidth * 0.8f
                
                // Crosshair Horizontal
                drawLine(
                    color = activeColor,
                    start = Offset(centerX - lineLength / 2, centerY),
                    end = Offset(centerX + lineLength / 2, centerY),
                    strokeWidth = 1.5.dp.toPx(),
                    cap = StrokeCap.Round
                )
                // Crosshair Vertical
                drawLine(
                    color = activeColor,
                    start = Offset(centerX, centerY - lineLength / 2),
                    end = Offset(centerX, centerY + lineLength / 2),
                    strokeWidth = 1.5.dp.toPx(),
                    cap = StrokeCap.Round
                )
                
                // Small dot in crosshair center
                drawCircle(
                    color = activeColor,
                    radius = 1.dp.toPx(),
                    center = Offset(centerX, centerY)
                )
            }
        }
    }
}

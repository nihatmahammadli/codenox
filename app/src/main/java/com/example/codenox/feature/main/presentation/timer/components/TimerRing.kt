package com.example.codenox.feature.main.presentation.timer.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun TimerRing(
    progress: Float,
    remainingTime: String,
    label: String,
    modifier: Modifier = Modifier
) {
    val primaryColor = CodeNoxTheme.colors.primary
    val trackColor = Color.White.copy(alpha = 0.05f)

    Box(
        modifier = modifier.size(280.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val strokeWidth = 12.dp.toPx()
            // Track
            drawCircle(
                color = trackColor,
                style = Stroke(width = strokeWidth)
            )
            // Progress
            drawArc(
                color = primaryColor,
                startAngle = -90f,
                sweepAngle = 360f * progress,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Butt)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = remainingTime,
                style = CodeNoxTheme.typography.jetBrainsMono24Bold.copy(fontSize = 48.sp),
                color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = label,
                style = CodeNoxTheme.typography.jetBrainsMono14Bold,
                color = CodeNoxTheme.colors.primary,
                letterSpacing = 2.sp
            )
        }
    }
}

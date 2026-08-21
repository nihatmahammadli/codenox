package com.example.codenox.feature.main.presentation.lesson.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LessonVideoPlayer(
    thumbnailUrl: String?,
    duration: String = "12:45",
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(24.dp))
            .clickable(onClick = onClick)
    ) {
        // Placeholder for thumbnail
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with real image loading like Coil
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        
        // Dark overlay
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.3f))
        )

        // Play Button
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color.White.copy(alpha = 0.2f), CircleShape)
                .align(Alignment.Center),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_right), // Placeholder
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }

        // Duration Tag
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .background(Color.Black.copy(alpha = 0.6f), RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Text(
                text = duration,
                color = Color.White,
                style = CodeNoxTheme.typography.dmSans12Bold
            )
        }
    }
}

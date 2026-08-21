package com.example.codenox.feature.main.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LessonCodeSnippet(
    code: String,
    fileName: String = "MainActivity.kt",
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFF121614), RoundedCornerShape(24.dp))
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                // Window controls dots
                Dot(Color(0xFFFF5F56))
                Dot(Color(0xFFFFBD2E))
                Dot(Color(0xFF27C93F))
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = fileName,
                    style = CodeNoxTheme.typography.dmSans12Medium,
                    color = CodeNoxTheme.colors.textSecondary
                )
            }
            
            Icon(
                painter = painterResource(id = R.drawable.ic_copy), 
                contentDescription = "Copy",
                tint = CodeNoxTheme.colors.textSecondary,
                modifier = Modifier.size(20.dp)
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = code,
            style = CodeNoxTheme.typography.jetBrainsMono14Regular,
            color = Color.White,
            lineHeight = 22.sp
        )
    }
}

@Composable
private fun Dot(color: Color) {
    Box(
        modifier = Modifier
            .size(8.dp)
            .background(color, CircleShape)
    )
}

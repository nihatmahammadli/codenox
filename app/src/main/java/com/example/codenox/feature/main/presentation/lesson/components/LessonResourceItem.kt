package com.example.codenox.feature.main.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.ResourceItem
import com.example.codenox.domain.model.ResourcePlatforms

@Composable
fun LessonResourceItem(
    resource: ResourceItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(CodeNoxTheme.colors.surface, RoundedCornerShape(24.dp))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val iconRes = when (resource.platform) {
            ResourcePlatforms.YOUTUBE -> R.drawable.ic_youtube // Placeholder
            ResourcePlatforms.GITHUB -> R.drawable.ic_github // Placeholder
            else -> R.drawable.ic_save // Placeholder
        }
        
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(32.dp)
        )
        
        Spacer(modifier = Modifier.width(16.dp))
        
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = resource.title,
                style = CodeNoxTheme.typography.dmSans16Bold,
                color = Color.White
            )
            Text(
                text = resource.description,
                style = CodeNoxTheme.typography.dmSans12Regular,
                color = CodeNoxTheme.colors.textSecondary
            )
        }
        
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            tint = CodeNoxTheme.colors.textSecondary,
            modifier = Modifier.size(20.dp)
        )
    }
}

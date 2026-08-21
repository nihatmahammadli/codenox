package com.example.codenox.feature.main.presentation.learn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LearnHeader(
    onSavedClick: () -> Unit,
    modifier: Modifier = Modifier,
    headerText: String = "Learn Android"
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = headerText,
            color = CodeNoxTheme.colors.textPrimary,
            style = CodeNoxTheme.typography.jetBrainsMono24Bold
        )

        IconButton(
            onClick = onSavedClick,
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFF121614), RoundedCornerShape(12.dp))
                .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(12.dp))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_save),
                contentDescription = "Saved Lessons",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
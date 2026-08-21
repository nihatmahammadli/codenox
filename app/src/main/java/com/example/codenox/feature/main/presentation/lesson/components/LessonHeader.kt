package com.example.codenox.feature.main.presentation.lesson.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LessonHeader(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    lessonNum: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(
            onClick = onBackClick,
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF121614), shape = RoundedCornerShape(16.dp))
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.08f),
                    RoundedCornerShape(16.dp)
                )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }

        Box(
            modifier = Modifier
                .background(CodeNoxTheme.colors.darkGreen, shape = CircleShape)
                .border(
                    width = 1.dp,
                    color = CodeNoxTheme.colors.primary,
                    shape = CircleShape
                )
                .padding(vertical = 8.dp, horizontal = 20.dp)
        ) {
            Text(
                text = "LESSON $lessonNum",
                color = CodeNoxTheme.colors.primary,
                style = CodeNoxTheme.typography.dmSans12Bold,
                letterSpacing = 1.sp
            )
        }

        IconButton(
            onClick = onSaveClick,
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF121614), shape = RoundedCornerShape(16.dp))
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.08f),
                    RoundedCornerShape(16.dp)
                )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_save),
                contentDescription = "Save",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}


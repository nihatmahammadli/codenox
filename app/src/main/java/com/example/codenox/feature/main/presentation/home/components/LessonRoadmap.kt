package com.example.codenox.feature.main.presentation.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.Lesson
import com.example.codenox.domain.model.LessonStatus
import com.example.codenox.domain.model.Module

@Composable
fun LessonRoadmap(
    module: Module,
    onLessonClick: (Lesson) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = module.title.uppercase(),
                style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                color = CodeNoxTheme.colors.textSecondary
            )

            SurfaceTag(text = "Module ${module.moduleNumber}")
        }

        Spacer(modifier = Modifier.height(8.dp))

        module.lessons.forEachIndexed { index, lesson ->
            LessonRoadmapItem(
                lesson = lesson,
                isLast = index == module.lessons.size - 1,
                onClick = { onLessonClick(lesson) }
            )
        }
    }
}

@Composable
private fun LessonRoadmapItem(
    lesson: Lesson,
    isLast: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .clickable(onClick = onClick)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(48.dp)
        ) {
            PathIndicator(status = lesson.status)
            
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .weight(1f)
                        .background(
                            if (lesson.status == LessonStatus.COMPLETED) 
                                CodeNoxTheme.colors.primary 
                            else 
                                CodeNoxTheme.colors.border
                        )
                )
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = 32.dp)
        ) {
            if (lesson.status == LessonStatus.ACTIVE) {
                ActiveLessonCard(
                    lesson = lesson,
                    onContinueClick = onClick
                )
            } else {
                CollapsedLessonItem(lesson = lesson)
            }
        }
    }
}

@Composable
private fun PathIndicator(status: LessonStatus) {
    val indicatorColor = CodeNoxTheme.colors.primary
    
    Box(
        modifier = Modifier.size(48.dp),
        contentAlignment = Alignment.Center
    ) {
        when (status) {
            LessonStatus.ACTIVE -> {
                Icon(
                    painter = painterResource(id = R.drawable.ic_active_lesson),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(36.dp)
                )
            }
            LessonStatus.COMPLETED -> {
                Box(
                    modifier = Modifier.size(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(
                            color = indicatorColor,
                            radius = size.minDimension / 2.2f,
                            style = Stroke(width = 2.dp.toPx())
                        )
                        drawCircle(
                            color = indicatorColor,
                            radius = 3.5.dp.toPx()
                        )
                    }
                }
            }
            LessonStatus.LOCKED -> {
                Icon(
                    painter = painterResource(id = R.drawable.ic_deactive_lesson),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
private fun CollapsedLessonItem(lesson: Lesson) {
    Column(modifier = Modifier.padding(top = 8.dp)) {
        Text(
            text = "${lesson.index}. ${lesson.category}",
            style = CodeNoxTheme.typography.dmSans14Medium,
            color = CodeNoxTheme.colors.textSecondary
        )
        Text(
            text = lesson.title,
            style = CodeNoxTheme.typography.jetBrainsMono18Bold,
            color = if (lesson.status == LessonStatus.LOCKED) 
                        CodeNoxTheme.colors.textSecondary 
                    else 
                        CodeNoxTheme.colors.textPrimary
        )
    }
}

@Composable
private fun SurfaceTag(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(CodeNoxTheme.colors.primary.copy(alpha = 0.1f))
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = text,
            style = CodeNoxTheme.typography.dmSans12Bold,
            color = CodeNoxTheme.colors.primary
        )
    }
}

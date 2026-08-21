package com.example.codenox.feature.main.presentation.lesson.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.LessonElement
import com.example.codenox.feature.main.presentation.lesson.LessonUiState

@Composable
fun LessonScreenContent(
    uiState: LessonUiState,
    onAction: (LessonAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val density = LocalDensity.current

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            LessonHeader(
                onBackClick = { onAction(LessonAction.OnBackClick) },
                onSaveClick = { onAction(LessonAction.OnSaveClick) },
                lessonNum = uiState.lessonNumber
            )

            LessonTitle(
                title = uiState.title,
                description = uiState.description
            )

            uiState.elements.forEach { element ->
                when (element) {
                    is LessonElement.Video -> {
                        LessonVideoPlayer(
                            thumbnailUrl = null,
                            onClick = { onAction(LessonAction.OnVideoClick(element.url)) }
                        )
                    }
                    is LessonElement.KeyConcepts -> {
                        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                            Text(
                                text = element.comment,
                                style = CodeNoxTheme.typography.jetBrainsMono14Bold,
                                color = CodeNoxTheme.colors.textSecondary
                            )
                            Text(
                                text = element.text,
                                style = CodeNoxTheme.typography.dmSans14Regular,
                                color = CodeNoxTheme.colors.textSecondary,
                                lineHeight = with(density) { 22.dp.toSp() }
                            )
                        }
                    }
                    is LessonElement.CodeBlock -> {
                        LessonCodeSnippet(code = element.code)
                    }
                    is LessonElement.Resources -> {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text(
                                text = "RESOURCES",
                                style = CodeNoxTheme.typography.jetBrainsMono14Bold,
                                color = CodeNoxTheme.colors.textSecondary
                            )
                            element.list.forEach { resource ->
                                LessonResourceItem(
                                    resource = resource,
                                    onClick = { onAction(LessonAction.OnResourceClick(resource.url)) }
                                )
                            }
                        }
                    }
                    is LessonElement.Practice -> {
                        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text(
                                text = "PRACTICE TASK",
                                style = CodeNoxTheme.typography.jetBrainsMono14Bold,
                                color = CodeNoxTheme.colors.textSecondary
                            )
                            LessonPracticeTask(
                                title = element.title,
                                level = element.level,
                                duration = element.time,
                                description = element.description
                            )
                        }
                    }
                    else -> {}
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { onAction(LessonAction.OnCompleteClick) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = CodeNoxTheme.colors.primary,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text(
                    text = "Mark as Complete",
                    style = CodeNoxTheme.typography.dmSans16Bold
                )
            }
        }
    }
}

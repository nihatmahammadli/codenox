package com.example.codenox.feature.main.presentation.lesson

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.LessonElement
import com.example.codenox.feature.main.presentation.lesson.components.*

@Composable
fun LessonScreen(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onCompleteClick: () -> Unit
) {
    val scrollState = rememberScrollState()
    val density = LocalDensity.current

    BaseScreen<LessonUiState, LessonViewModel> { uiState, viewModel ->
        CodeNoxBackground {
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
                    onBackClick = onBackClick,
                    onSaveClick = { 
                        onSaveClick()
                        viewModel.toggleSave()
                    },
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
                                onClick = { /* Handle video click */ }
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
                            LessonCodeSnippet(
                                code = element.code
                            )
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
                                        onClick = { /* Open URL */ }
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

                Button(
                    onClick = {
                        viewModel.completeLesson()
                        onCompleteClick()
                    },
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
                        text = "Mark as Complete ✓",
                        style = CodeNoxTheme.typography.dmSans16Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun LessonScreenPreview() {
    LessonScreen(
        onBackClick = {},
        onSaveClick = {},
        onCompleteClick = {}
    )
}

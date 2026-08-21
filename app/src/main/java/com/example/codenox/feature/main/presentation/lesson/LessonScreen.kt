package com.example.codenox.feature.main.presentation.lesson

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.feature.main.presentation.lesson.components.LessonAction
import com.example.codenox.feature.main.presentation.lesson.components.LessonScreenContent

@Composable
fun LessonScreen(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onCompleteClick: () -> Unit
) {
    BaseScreen<LessonUiState, LessonViewModel> { uiState, viewModel ->
        LessonScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    LessonAction.OnBackClick -> onBackClick()
                    LessonAction.OnSaveClick -> {
                        onSaveClick()
                        viewModel.toggleSave()
                    }
                    LessonAction.OnCompleteClick -> {
                        viewModel.completeLesson()
                        onCompleteClick()
                    }
                    is LessonAction.OnResourceClick -> { }
                    is LessonAction.OnVideoClick -> { }
                }
            }
        )
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

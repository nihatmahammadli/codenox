package com.example.codenox.feature.main.presentation.saved

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.feature.main.presentation.saved.components.SavedLessonAction
import com.example.codenox.feature.main.presentation.saved.components.SavedLessonScreenContent

@Composable
fun SavedLessonScreen(
    onBackClick: () -> Unit,
    onLessonClick: (String) -> Unit
) {
    BaseScreen<SavedLessonUiState, SavedLessonViewModel> { uiState, viewModel ->
        SavedLessonScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    SavedLessonAction.OnBackClick -> onBackClick()
                    is SavedLessonAction.OnBookmarkClick -> viewModel.toggleBookmark(action.lessonId)
                    is SavedLessonAction.OnLessonClick -> onLessonClick(action.lessonId)
                    is SavedLessonAction.OnSearchQueryChange -> viewModel.onSearchQueryChange(action.query)
                }
            }
        )
    }
}

@Preview
@Composable
fun SavedLessonScreenPreview() {
    SavedLessonScreen(onBackClick = {}, onLessonClick = {})
}

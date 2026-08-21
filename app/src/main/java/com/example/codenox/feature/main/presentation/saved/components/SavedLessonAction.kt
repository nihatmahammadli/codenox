package com.example.codenox.feature.main.presentation.saved.components

sealed interface SavedLessonAction {
    data object OnBackClick : SavedLessonAction
    data class OnSearchQueryChange(val query: String) : SavedLessonAction
    data class OnBookmarkClick(val lessonId: String) : SavedLessonAction
    data class OnLessonClick(val lessonId: String) : SavedLessonAction
}

package com.example.codenox.feature.main.presentation.saved

import com.example.codenox.domain.model.SavedLesson

data class SavedLessonUiState(
    val searchQuery: String = "",
    val savedLessons: List<SavedLesson> = emptyList(),
    val isLoading: Boolean = false
)

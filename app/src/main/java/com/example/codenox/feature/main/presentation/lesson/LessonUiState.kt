package com.example.codenox.feature.main.presentation.lesson

import com.example.codenox.domain.model.LessonElement

data class LessonUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val lessonNumber: String = "02",
    val title: String = "",
    val description: String = "",
    val elements: List<LessonElement> = emptyList(),
    val isSaved: Boolean = false,
    val isCompleted: Boolean = false
)

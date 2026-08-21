package com.example.codenox.domain.model

data class SavedLesson(
    val id: String,
    val lessonNumber: String,
    val title: String,
    val description: String,
    val progress: Int,
    val level: String,
    val isBookmarked: Boolean = true
)

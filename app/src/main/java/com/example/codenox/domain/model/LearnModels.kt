package com.example.codenox.domain.model

data class ContinueLearning(
    val lessonNumber: String,
    val title: String,
    val description: String,
    val duration: String,
    val level: String
)

data class LearningPath(
    val id: String,
    val title: String,
    val totalLessons: Int,
    val completedLessons: Int,
    val level: String? = null,
    val iconRes: Int? = null
)

data class PopularLesson(
    val id: String,
    val title: String,
    val level: String,
    val duration: String,
    val xp: Int,
    val isBookmarked: Boolean = false
)

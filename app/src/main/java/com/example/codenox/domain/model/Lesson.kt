package com.example.codenox.domain.model

enum class LessonStatus {
    COMPLETED,
    ACTIVE,
    LOCKED
}

data class Lesson(
    val id: String,
    val index: String,
    val category: String,
    val title: String,
    val description: String = "",
    val duration: String = "",
    val xp: Int = 0,
    val status: LessonStatus = LessonStatus.LOCKED
)

data class Module(
    val id: String,
    val title: String,
    val moduleNumber: Int,
    val lessons: List<Lesson>
)

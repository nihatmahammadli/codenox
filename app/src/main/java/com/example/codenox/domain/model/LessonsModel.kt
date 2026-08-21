package com.example.codenox.domain.model

data class LessonsModel(
    val id: String,
    val title: String,
    val lessonNum: String,
    val elements: List<LessonElement>
)

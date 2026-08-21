package com.example.codenox.domain.model

sealed interface LessonElement {
    data class TextElement(
        val text: String
    ) : LessonElement

    data class Video(
        val url: String,
    ) : LessonElement

    data class KeyConcepts(
        val comment: String,
        val text: String,
        val keyPoints: List<String>
    ) : LessonElement

    data class CodeBlock(
        val code: String,
        val language: String
    ) : LessonElement

    data class Resources(
        val list: List<ResourceItem>
    ) : LessonElement

    data class Practice(
        val title: String,
        val level: String,
        val time: String,
        val description: String,
    ) : LessonElement
}



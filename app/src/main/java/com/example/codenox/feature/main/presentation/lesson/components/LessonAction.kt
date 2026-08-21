package com.example.codenox.feature.main.presentation.lesson.components

sealed interface LessonAction {
    data object OnBackClick : LessonAction
    data object OnSaveClick : LessonAction
    data object OnCompleteClick : LessonAction
    data class OnVideoClick(val url: String) : LessonAction
    data class OnResourceClick(val url: String) : LessonAction
}

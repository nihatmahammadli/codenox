package com.example.codenox.feature.main.presentation.learn.components

sealed interface LearnAction {
    data object OnResumeClick : LearnAction
    data object OnSavedClick : LearnAction
    data class OnSearchQueryChange(val query: String) : LearnAction
    data class OnCategorySelected(val category: String) : LearnAction
}

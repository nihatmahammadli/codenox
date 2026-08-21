package com.example.codenox.feature.main.presentation.learn

import com.example.codenox.domain.model.ContinueLearning
import com.example.codenox.domain.model.LearningPath
import com.example.codenox.domain.model.PopularLesson

data class LearnUiState(
    val continueLearning: ContinueLearning? = null,
    val learningPaths: List<LearningPath> = emptyList(),
    val popularLessons: List<PopularLesson> = emptyList(),
    val searchQuery: String = "",
    val selectedCategory: String = "All",
    val categories: List<String> = listOf("All", "Fundamentals", "UX/UI", "Data store")
)

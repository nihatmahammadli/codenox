package com.example.codenox.feature.main.presentation.learn

import com.example.codenox.core.designsystem.base.BaseViewModel
import com.example.codenox.domain.model.ContinueLearning
import com.example.codenox.domain.model.LearningPath
import com.example.codenox.domain.model.PopularLesson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LearnViewModel @Inject constructor() : BaseViewModel<LearnUiState>() {

    override fun getInitialUiState(): LearnUiState = LearnUiState(
        continueLearning = ContinueLearning(
            lessonNumber = "1.1",
            title = "Getting Started",
            description = "Your first step into Android development. Learn about the tools and basic structure.",
            duration = "10m",
            level = "Beginner"
        ),
        learningPaths = listOf(
            LearningPath(id = "1", title = "Build Your First App", totalLessons = 12, completedLessons = 0, level = "Beginner"),
            LearningPath(id = "2", title = "Kotlin Fundamentals", totalLessons = 10, completedLessons = 0, level = "Beginner")
        ),
        popularLessons = listOf(
            PopularLesson(id = "1", title = "Variables & Types", level = "Beginner", duration = "15m", xp = 30),
            PopularLesson(id = "2", title = "Control Flow", level = "Beginner", duration = "20m", xp = 40),
            PopularLesson(id = "3", title = "Functions Basics", level = "Beginner", duration = "18m", xp = 35)
        )
    )

    fun onSearchQueryChange(query: String) {
        updateState { it.copy(searchQuery = query) }
    }

    fun onCategorySelected(category: String) {
        updateState { it.copy(selectedCategory = category) }
    }
}

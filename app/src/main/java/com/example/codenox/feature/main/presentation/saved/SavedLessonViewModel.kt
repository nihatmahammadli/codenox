package com.example.codenox.feature.main.presentation.saved

import com.example.codenox.core.designsystem.base.BaseViewModel
import com.example.codenox.domain.model.SavedLesson
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SavedLessonViewModel @Inject constructor() : BaseViewModel<SavedLessonUiState>() {

    override fun getInitialUiState(): SavedLessonUiState = SavedLessonUiState(
        savedLessons = listOf(
            SavedLesson(
                id = "1",
                lessonNumber = "02",
                title = "Activities and Intents",
                description = "Learn how to navigate between screens and pass data using explicit and implicit intents in Android.",
                progress = 45,
                level = "Intermediate"
            ),
            SavedLesson(
                id = "2",
                lessonNumber = "04",
                title = "Retrofit: API Handling",
                description = "Master network requests and JSON parsing with the industry-standard networking client.",
                progress = 100,
                level = "Intermediate"
            ),
            SavedLesson(
                id = "3",
                lessonNumber = "01",
                title = "Jetpack Compose Basics",
                description = "Build modern declarative UI layouts with state management, modifiers and basic composables.",
                progress = 80,
                level = "Beginner"
            )
        )
    )

    fun onSearchQueryChange(query: String) {
        updateState { it.copy(searchQuery = query) }
    }

    fun toggleBookmark(lessonId: String) {
        // In a real app, this would call a repository
        updateState { state ->
            state.copy(
                savedLessons = state.savedLessons.filter { it.id != lessonId }
            )
        }
    }
}

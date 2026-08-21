package com.example.codenox.feature.main.presentation.lesson

import com.example.codenox.core.designsystem.base.BaseViewModel
import com.example.codenox.domain.model.LessonElement
import com.example.codenox.domain.model.ResourceItem
import com.example.codenox.domain.model.ResourcePlatforms
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LessonViewModel @Inject constructor(): BaseViewModel<LessonUiState>() {
    override fun getInitialUiState(): LessonUiState = LessonUiState(
        lessonNumber = "02",
        title = "Activities and Intents",
        description = "Learn how to navigate between screens and pass data using explicit and implicit intents in Android. This lesson covers Activity lifecycle, Intent types, and data passing patterns.",
        elements = listOf(
            LessonElement.Video(
                url = "https://example.com/video.mp4"
            ),
            LessonElement.KeyConcepts(
                comment = "KEY CONCEPTS",
                text = "An Intent is a messaging object you can use to request an action from another app component. Use explicit intents to launch specific activities in your own app.",
                keyPoints = emptyList()
            ),
            LessonElement.CodeBlock(
                code = """
                    // Create explicit intent to target SecondActivity
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("key", value)
                    startActivity(intent)
                """.trimIndent(),
                language = "kotlin"
            ),
            LessonElement.Resources(
                list = listOf(
                    ResourceItem(
                        title = "Watch on YouTube",
                        url = "https://youtube.com",
                        description = "Video Walkthrough • 15 mins",
                        videoTime = "15:00",
                        platform = ResourcePlatforms.YOUTUBE
                    ),
                    ResourceItem(
                        title = "View Source Code",
                        url = "https://github.com",
                        description = "Example Repository on GitHub",
                        videoTime = "",
                        platform = ResourcePlatforms.GITHUB
                    )
                )
            ),
            LessonElement.Practice(
                title = "Intent Data Passer",
                level = "Intermediate",
                time = "25 min",
                description = "Create an app with two activities. Pass a username from the first activity to the second using an intent extra, and display it in a TextView."
            )
        )
    )

    fun toggleSave() {
        updateState { it.copy(isSaved = !it.isSaved) }
    }

    fun completeLesson() {
        updateState { it.copy(isCompleted = true) }
    }
}

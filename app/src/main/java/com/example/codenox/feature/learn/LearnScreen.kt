package com.example.codenox.feature.learn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.ContinueLearning
import com.example.codenox.domain.model.LearningPath
import com.example.codenox.domain.model.PopularLesson
import com.example.codenox.feature.learn.components.*

@Composable
fun LearnScreen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }

    // Sample Data
    val continueLearningData = ContinueLearning(
        lessonNumber = "2.4",
        title = "Retrofit: API Handling",
        description = "Master network requests and JSON parsing with the industry-standard library.",
        duration = "22m",
        level = "Intermediate"
    )

    val learningPaths = listOf(
        LearningPath(id = "1", title = "Build Your First App", totalLessons = 12, completedLessons = 4),
        LearningPath(id = "2", title = "Master Jetpack Compose", totalLessons = 8, completedLessons = 0, level = "Beginner")
    )

    val popularLessons = listOf(
        PopularLesson(id = "1", title = "Dependency Injection with Hilt", level = "Intermediate", duration = "45m", xp = 120),
        PopularLesson(id = "2", title = "Kotlin Coroutines Deep Dive", level = "Advanced", duration = "38m", xp = 150),
        PopularLesson(id = "3", title = "Navigation Component", level = "Beginner", duration = "25m", xp = 80)
    )

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            LearnHeader()
            
            LearnSearchBar(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                categories = listOf("All", "Fundamentals", "UX/UI", "Data store"),
                selectedCategory = selectedCategory,
                onCategorySelected = { selectedCategory = it }
            )

            SectionHeader(title = "CONTINUE LEARNING")
            ContinueLearningCard(
                data = continueLearningData,
                onResumeClick = { /* Handle resume */ }
            )

            // Learning Paths Section
            SectionHeader(
                title = "LEARNING PATHS",
                actionText = "View All",
                onActionClick = { /* Handle view all */ }
            )
            learningPaths.forEach { path ->
                LearningPathCard(
                    path = path,
                    onClick = { /* Handle path click */ }
                )
            }

            // Popular Lessons Section
            SectionHeader(title = "POPULAR LESSONS")
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                popularLessons.forEach { lesson ->
                    PopularLessonItem(
                        lesson = lesson,
                        onClick = { /* Handle lesson click */ },
                        onBookmarkClick = { /* Handle bookmark */ }
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(
    title: String,
    actionText: String? = null,
    onActionClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = CodeNoxTheme.typography.jetBrainsMono18Bold,
            color = CodeNoxTheme.colors.textSecondary
        )
        if (actionText != null && onActionClick != null) {
            Text(
                text = actionText,
                style = CodeNoxTheme.typography.dmSans14Bold,
                color = CodeNoxTheme.colors.primary,
                modifier = Modifier.clickable(onClick = onActionClick)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0B0D0C)
@Composable
private fun LearnScreenPreview() {
    CodeNoxTheme {
        LearnScreen()
    }
}

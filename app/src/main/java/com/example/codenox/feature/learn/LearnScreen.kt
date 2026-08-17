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

    // Reset Sample Data
    val continueLearningData = ContinueLearning(
        lessonNumber = "1.1",
        title = "Getting Started",
        description = "Your first step into Android development. Learn about the tools and basic structure.",
        duration = "10m",
        level = "Beginner"
    )

    val learningPaths = listOf(
        LearningPath(id = "1", title = "Build Your First App", totalLessons = 12, completedLessons = 0, level = "Beginner"),
        LearningPath(id = "2", title = "Kotlin Fundamentals", totalLessons = 10, completedLessons = 0, level = "Beginner")
    )

    val popularLessons = listOf(
        PopularLesson(id = "1", title = "Variables & Types", level = "Beginner", duration = "15m", xp = 30),
        PopularLesson(id = "2", title = "Control Flow", level = "Beginner", duration = "20m", xp = 40),
        PopularLesson(id = "3", title = "Functions Basics", level = "Beginner", duration = "18m", xp = 35)
    )

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp),
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

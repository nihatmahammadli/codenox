package com.example.codenox.feature.main.presentation.learn.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.learn.LearnUiState
import androidx.compose.foundation.clickable

@Composable
fun LearnScreenContent(
    uiState: LearnUiState,
    onAction: (LearnAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            LearnHeader(onSavedClick = { onAction(LearnAction.OnSavedClick) })

            LearnSearchBar(
                query = uiState.searchQuery,
                onQueryChange = { onAction(LearnAction.OnSearchQueryChange(it)) },
                categories = uiState.categories,
                selectedCategory = uiState.selectedCategory,
                onCategorySelected = { onAction(LearnAction.OnCategorySelected(it)) }
            )

            uiState.continueLearning?.let { data ->
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    SectionHeader(title = "CONTINUE LEARNING")
                    ContinueLearningCard(
                        data = data,
                        onResumeClick = { onAction(LearnAction.OnResumeClick) }
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                SectionHeader(
                    title = "LEARNING PATHS",
                    actionText = "View All",
                    onActionClick = { }
                )
                uiState.learningPaths.forEach { path ->
                    LearningPathCard(
                        path = path,
                        onClick = { }
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                SectionHeader(title = "POPULAR LESSONS")
                uiState.popularLessons.forEach { lesson ->
                    PopularLessonItem(
                        lesson = lesson,
                        onClick = { },
                        onBookmarkClick = { }
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

package com.example.codenox.feature.main.presentation.learn

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
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.learn.components.ContinueLearningCard
import com.example.codenox.feature.main.presentation.learn.components.LearnHeader
import com.example.codenox.feature.main.presentation.learn.components.LearnSearchBar
import com.example.codenox.feature.main.presentation.learn.components.LearningPathCard
import com.example.codenox.feature.main.presentation.learn.components.PopularLessonItem

@Composable
fun LearnScreen(
    modifier: Modifier = Modifier,
    onResumeClick: () -> Unit = {},
    onSavedClick: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    BaseScreen<LearnUiState, LearnViewModel> { uiState, viewModel ->
        CodeNoxBackground(modifier = modifier) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                LearnHeader(onSavedClick = onSavedClick)

                LearnSearchBar(
                    query = uiState.searchQuery,
                    onQueryChange = viewModel::onSearchQueryChange,
                    categories = uiState.categories,
                    selectedCategory = uiState.selectedCategory,
                    onCategorySelected = viewModel::onCategorySelected
                )

                uiState.continueLearning?.let { data ->
                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        SectionHeader(title = "CONTINUE LEARNING")
                        ContinueLearningCard(
                            data = data,
                            onResumeClick = onResumeClick
                        )
                    }
                }

                // Learning Paths Section
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    SectionHeader(
                        title = "LEARNING PATHS",
                        actionText = "View All",
                        onActionClick = { /* Handle view all */ }
                    )
                    uiState.learningPaths.forEach { path ->
                        LearningPathCard(
                            path = path,
                            onClick = { /* Handle path click */ }
                        )
                    }
                }

                // Popular Lessons Section
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    SectionHeader(title = "POPULAR LESSONS")
                    uiState.popularLessons.forEach { lesson ->
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

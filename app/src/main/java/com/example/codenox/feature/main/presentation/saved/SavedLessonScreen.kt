package com.example.codenox.feature.main.presentation.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.saved.components.SavedLessonCard

@Composable
fun SavedLessonScreen(
    onBackClick: () -> Unit,
    onLessonClick: (String) -> Unit
) {
    BaseScreen<SavedLessonUiState, SavedLessonViewModel> { uiState, viewModel ->
        CodeNoxBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp)
            ) {
                // Header
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color(0xFF121614), RoundedCornerShape(16.dp))
                            .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(16.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Text(
                        text = "Saved Lessons",
                        style = CodeNoxTheme.typography.dmSans24Bold,
                        color = Color.White
                    )

                    IconButton(
                        onClick = { /* Filter */ },
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color(0xFF121614), RoundedCornerShape(16.dp))
                            .border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(16.dp))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings), // Use a filter icon if available
                            contentDescription = "Filter",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Search Bar
                TextField(
                    value = uiState.searchQuery,
                    onValueChange = viewModel::onSearchQueryChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(32.dp)),
                    placeholder = {
                        Text(
                            text = "Search saved lessons...",
                            style = CodeNoxTheme.typography.dmSans14Regular,
                            color = CodeNoxTheme.colors.textSecondary
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = null,
                            tint = CodeNoxTheme.colors.textSecondary,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = CodeNoxTheme.colors.surface,
                        unfocusedContainerColor = CodeNoxTheme.colors.surface,
                        disabledContainerColor = CodeNoxTheme.colors.surface,
                        cursorColor = CodeNoxTheme.colors.primary,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    singleLine = true,
                    textStyle = CodeNoxTheme.typography.dmSans14Regular.copy(color = Color.White)
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Stats and Sorting
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${uiState.savedLessons.size} LESSONS SAVED",
                        style = CodeNoxTheme.typography.jetBrainsMono14Bold,
                        color = CodeNoxTheme.colors.textSecondary
                    )
                    
                    Text(
                        text = "Sorted by recent",
                        style = CodeNoxTheme.typography.dmSans14Bold,
                        color = CodeNoxTheme.colors.primary,
                        modifier = Modifier.clickable { /* Handle sort */ }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Lessons List
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {
                    items(uiState.savedLessons) { lesson ->
                        SavedLessonCard(
                            lesson = lesson,
                            onBookmarkClick = { viewModel.toggleBookmark(lesson.id) },
                            onStartClick = { onLessonClick(lesson.id) }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SavedLessonScreenPreview() {
    SavedLessonScreen(onBackClick = {}, onLessonClick = {})
}

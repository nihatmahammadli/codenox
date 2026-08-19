package com.example.codenox.feature.main.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.HistoryItem
import com.example.codenox.domain.model.Lesson
import com.example.codenox.domain.model.LessonStatus
import com.example.codenox.domain.model.Module
import com.example.codenox.feature.main.presentation.home.components.ActiveLessonCard
import com.example.codenox.feature.main.presentation.home.components.DailyGoalCard
import com.example.codenox.feature.main.presentation.home.components.HomeHeader
import com.example.codenox.feature.main.presentation.home.components.JumpBackInSection
import com.example.codenox.feature.main.presentation.home.components.LessonRoadmap
import com.example.codenox.feature.main.presentation.home.components.StreakCard

@Composable
fun HomeScreen(
    onLearnClick: () -> Unit = {},
    onTrophiesClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    val historyItems = emptyList<HistoryItem>()

    val activeLesson = Lesson(
        id = "1",
        index = "01",
        category = "Fundamentals",
        title = "Getting Started",
        description = "Learn the basics of Android development and set up your environment.",
        duration = "10m",
        xp = 20,
        status = LessonStatus.ACTIVE
    )

    val sampleModule = Module(
        id = "1",
        title = "Kotlin Basics",
        moduleNumber = 1,
        lessons = listOf(
            activeLesson,
            Lesson(
                id = "2",
                index = "02",
                category = "Fundamentals",
                title = "Variables & Types",
                status = LessonStatus.LOCKED
            )
        )
    )
    BaseScreen<HomeUiState,HomeViewModel>() { uiState, viewModel ->

        CodeNoxBackground(modifier = modifier) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp, bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                HomeHeader(
                    fullName = uiState.profile?.fullName ?: "New Developer",
                    profileImage = R.drawable.ic_default_profile,
                    onProfileClick = onProfileClick
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    StreakCard(
                        modifier = Modifier.weight(1f),
                        onStreakClick = onTrophiesClick
                    )
                    DailyGoalCard(modifier = Modifier.weight(1f))
                }

                ActiveLessonCard(
                    lesson = activeLesson,
                    onContinueClick = onLearnClick
                )

                LessonRoadmap(
                    module = sampleModule,
                    onLessonClick = { /* Handle click */ }
                )

                JumpBackInSection(
                    historyItems = historyItems,
                    onItemClick = { /* Handle click */ }
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0B0D0C)
@Composable
private fun HomeScreenPreview() {
    CodeNoxTheme {
        HomeScreen()
    }
}

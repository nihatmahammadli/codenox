package com.example.codenox.feature.main.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.domain.model.HistoryItem
import com.example.codenox.domain.model.Lesson
import com.example.codenox.domain.model.LessonStatus
import com.example.codenox.domain.model.Module
import com.example.codenox.feature.main.presentation.home.HomeUiState

@Composable
fun HomeScreenContent(
    uiState: HomeUiState,
    onAction: (HomeAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val historyItems = remember { emptyList<HistoryItem>() }
    val activeLesson = remember {
        Lesson(
            id = "1",
            index = "01",
            category = "Fundamentals",
            title = "Getting Started",
            description = "Learn the basics of Android development and set up your environment.",
            duration = "10m",
            xp = 20,
            status = LessonStatus.ACTIVE
        )
    }
    val sampleModule = remember(activeLesson) {
        Module(
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
    }

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
                onProfileClick = { onAction(HomeAction.OnProfileClick) }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                StreakCard(
                    modifier = Modifier.weight(1f),
                    onStreakClick = { onAction(HomeAction.OnTrophiesClick) }
                )
                DailyGoalCard(
                    modifier = Modifier.weight(1f),
                    onClick = { onAction(HomeAction.OnTimerClick) }
                )
            }

            ActiveLessonCard(
                lesson = activeLesson,
                onContinueClick = { onAction(HomeAction.OnLearnClick) }
            )

            LessonRoadmap(
                module = sampleModule,
                onLessonClick = { }
            )

            JumpBackInSection(
                historyItems = historyItems,
                onItemClick = { }
            )
        }
    }
}

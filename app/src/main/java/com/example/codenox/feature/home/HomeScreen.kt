package com.example.codenox.feature.home

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
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.HistoryItem
import com.example.codenox.domain.model.Lesson
import com.example.codenox.domain.model.LessonStatus
import com.example.codenox.domain.model.Module
import com.example.codenox.feature.home.components.ActiveLessonCard
import com.example.codenox.feature.home.components.DailyGoalCard
import com.example.codenox.feature.home.components.HomeHeader
import com.example.codenox.feature.home.components.JumpBackInSection
import com.example.codenox.feature.home.components.LessonRoadmap
import com.example.codenox.feature.home.components.StreakCard

@Composable
fun HomeScreen(
    onLearnClick: () -> Unit = {},
    onTrophiesClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    // Sample Data
    val historyItems = listOf(
        HistoryItem(id = "1", title = "Kotlin Syntax Recap", type = "Cheatsheet"),
        HistoryItem(id = "2", title = "Intro to Room", type = "Article", duration = "5 min")
    )

    val activeLesson = Lesson(
        id = "2",
        index = "02",
        category = "Navigation",
        title = "Activities and Intents",
        description = "Learn how to navigate between screens and pass data using explicit and implicit intents in Android.",
        duration = "15m",
        xp = 50,
        status = LessonStatus.ACTIVE
    )

    val sampleModule = Module(
        id = "1",
        title = "Android Path",
        moduleNumber = 2,
        lessons = listOf(
            Lesson(
                id = "1",
                index = "01",
                category = "UI Basics",
                title = "Views & ViewGroups",
                status = LessonStatus.COMPLETED
            ),
            activeLesson,
            Lesson(
                id = "3",
                index = "03",
                category = "Lifecycle",
                title = "Activity Lifecycles",
                status = LessonStatus.LOCKED
            ),
            Lesson(
                id = "4",
                index = "04",
                category = "UI Polish",
                title = "Material 3 in Compose",
                status = LessonStatus.LOCKED
            )
        )
    )

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            HomeHeader(
                userName = "Nihat Mahammadli",
                profileImage = com.example.codenox.R.drawable.ic_default_profile,
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

@Preview(showBackground = true, backgroundColor = 0xFF0B0D0C)
@Composable
private fun HomeScreenPreview() {
    CodeNoxTheme {
        HomeScreen()
    }
}

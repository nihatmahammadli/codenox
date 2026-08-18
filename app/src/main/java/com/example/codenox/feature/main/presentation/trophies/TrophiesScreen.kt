package com.example.codenox.feature.main.presentation.trophies

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.domain.model.*
import com.example.codenox.feature.main.presentation.trophies.components.BadgesRow
import com.example.codenox.feature.main.presentation.trophies.components.ChallengeCard
import com.example.codenox.feature.main.presentation.trophies.components.LeaderboardCard
import com.example.codenox.feature.main.presentation.trophies.components.MilestoneCard
import com.example.codenox.feature.main.presentation.trophies.components.SectionHeader
import com.example.codenox.feature.main.presentation.trophies.components.TrophyHeader

@Composable
fun TrophiesScreen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    val userInfo = UserTrophyInfo(totalXp = "0", level = 0, rank = 0)
    val nextMilestone = Milestone(title = "Getting Started", currentXp = 0, targetXp = 100)
    val badges = listOf(
        Badge(id = "1", isLocked = true),
        Badge(id = "2", isLocked = true),
        Badge(id = "3", isLocked = true),
        Badge(id = "4", isLocked = true)
    )
    val leaderboard = listOf(
        LeaderboardEntry(id = "1", rank = 1, name = "Top Developer", xp = "100"),
        LeaderboardEntry(id = "2", rank = 2, name = "You", xp = "0", isCurrentUser = true)
    )
    val challenge = Challenge(
        id = "1",
        title = "First Lesson",
        description = "Complete your first lesson to start",
        currentProgress = 0,
        totalGoal = 1
    )

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TrophyHeader(userInfo)

            MilestoneCard(nextMilestone)

            Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                SectionHeader(title = "RECENT BADGES", actionText = "View All")
                BadgesRow(badges)

                SectionHeader(title = "GLOBAL LEADERBOARD")
                LeaderboardCard(leaderboard)

                SectionHeader(title = "ACTIVE CHALLENGES")
                ChallengeCard(challenge)
            }
        }
    }
}


@Preview(showBackground = true, backgroundColor = 0xFF0B0D0C)
@Composable
private fun TrophiesScreenPreview() {
    CodeNoxTheme {
        TrophiesScreen()
    }
}

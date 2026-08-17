package com.example.codenox.feature.trophies

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
import com.example.codenox.feature.trophies.components.*

@Composable
fun TrophiesScreen(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    // Sample Data
    val userInfo = UserTrophyInfo(totalXp = "14,250", level = 12, rank = 2)
    val nextMilestone = Milestone(title = "Compose Architect", currentXp = 750, targetXp = 1000)
    val badges = listOf(
        Badge(id = "1"),
        Badge(id = "2"),
        Badge(id = "3", isNew = true),
        Badge(id = "4", isLocked = true)
    )
    val leaderboard = listOf(
        LeaderboardEntry(id = "1", rank = 1, name = "Alex Chen", xp = "16,420"),
        LeaderboardEntry(id = "2", rank = 2, name = "Nihat M. (You)", xp = "14,250", isCurrentUser = true),
        LeaderboardEntry(id = "3", rank = 3, name = "Sarah Miller", xp = "13,980")
    )
    val challenge = Challenge(
        id = "1",
        title = "Weekend Warrior",
        description = "Complete 3 lessons this weekend",
        currentProgress = 1,
        totalGoal = 3
    )

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
                .padding(bottom = 24.dp),
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
        if (actionText != null) {
            Text(
                text = actionText,
                style = CodeNoxTheme.typography.dmSans14Bold,
                color = CodeNoxTheme.colors.primary,
                modifier = Modifier.clickable { onActionClick?.invoke() }
            )
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

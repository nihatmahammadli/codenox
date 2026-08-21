package com.example.codenox.feature.main.presentation.trophies.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.feature.main.presentation.trophies.TrophiesUiState

@Composable
fun TrophiesScreenContent(
    uiState: TrophiesUiState,
    onAction: (TrophiesAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

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
            TrophyHeader(uiState.userInfo)

            MilestoneCard(uiState.nextMilestone)

            Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
                SectionHeader(
                    title = "RECENT BADGES",
                    actionText = "View All",
                    onActionClick = { onAction(TrophiesAction.OnViewAllBadgesClick) }
                )
                BadgesRow(uiState.badges)

                SectionHeader(title = "GLOBAL LEADERBOARD")
                LeaderboardCard(uiState.leaderboard)

                uiState.challenge?.let {
                    SectionHeader(title = "ACTIVE CHALLENGES")
                    ChallengeCard(it)
                }
            }
        }
    }
}

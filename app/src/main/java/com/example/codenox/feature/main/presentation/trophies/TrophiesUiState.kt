package com.example.codenox.feature.main.presentation.trophies

import com.example.codenox.domain.model.*

data class TrophiesUiState(
    val userInfo: UserTrophyInfo = UserTrophyInfo(totalXp = "0", level = 0, rank = 0),
    val nextMilestone: Milestone = Milestone(title = "Getting Started", currentXp = 0, targetXp = 100),
    val badges: List<Badge> = emptyList(),
    val leaderboard: List<LeaderboardEntry> = emptyList(),
    val challenge: Challenge? = null
)

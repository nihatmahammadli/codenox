package com.example.codenox.feature.main.presentation.trophies

import com.example.codenox.core.designsystem.base.BaseViewModel
import com.example.codenox.domain.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrophiesViewModel @Inject constructor() : BaseViewModel<TrophiesUiState>() {
    override fun getInitialUiState() = TrophiesUiState(
        badges = listOf(
            Badge(id = "1", isLocked = true),
            Badge(id = "2", isLocked = true),
            Badge(id = "3", isLocked = true),
            Badge(id = "4", isLocked = true)
        ),
        leaderboard = listOf(
            LeaderboardEntry(id = "1", rank = 1, name = "Top Developer", xp = "100"),
            LeaderboardEntry(id = "2", rank = 2, name = "You", xp = "0", isCurrentUser = true)
        ),
        challenge = Challenge(
            id = "1",
            title = "First Lesson",
            description = "Complete your first lesson to start",
            currentProgress = 0,
            totalGoal = 1
        )
    )
}

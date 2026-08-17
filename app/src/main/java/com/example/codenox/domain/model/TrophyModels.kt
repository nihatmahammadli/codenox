package com.example.codenox.domain.model

data class UserTrophyInfo(
    val totalXp: String,
    val level: Int,
    val rank: Int,
    val mainBadgeRes: Int? = null
)

data class Milestone(
    val title: String,
    val currentXp: Int,
    val targetXp: Int
)

data class Badge(
    val id: String,
    val iconRes: Int? = null,
    val isLocked: Boolean = false,
    val isNew: Boolean = false
)

data class LeaderboardEntry(
    val id: String,
    val rank: Int,
    val name: String,
    val xp: String,
    val profileImageRes: Int? = null,
    val isCurrentUser: Boolean = false
)

data class Challenge(
    val id: String,
    val title: String,
    val description: String,
    val currentProgress: Int,
    val totalGoal: Int,
    val iconRes: Int? = null
)

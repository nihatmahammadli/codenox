package com.example.codenox.feature.main.presentation.dailygoal

data class DailyGoalUiState(
    val selectedHour: Int = 0,
    val selectedMinute: Int = 45,
    val isLoading: Boolean = false
)

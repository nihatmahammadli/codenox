package com.example.codenox.feature.main.presentation.dailygoal.components

sealed interface DailyGoalAction {
    data object OnBackClick : DailyGoalAction
    data object OnSaveClick : DailyGoalAction
    data class OnHourChange(val hour: Int) : DailyGoalAction
    data class OnMinuteChange(val minute: Int) : DailyGoalAction
}

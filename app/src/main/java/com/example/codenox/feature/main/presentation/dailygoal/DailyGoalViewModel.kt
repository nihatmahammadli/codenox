package com.example.codenox.feature.main.presentation.dailygoal

import com.example.codenox.core.designsystem.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DailyGoalViewModel @Inject constructor() : BaseViewModel<DailyGoalUiState>() {
    override fun getInitialUiState() = DailyGoalUiState()

    fun onHourChange(hour: Int) {
        updateState { it.copy(selectedHour = hour) }
    }

    fun onMinuteChange(minute: Int) {
        updateState { it.copy(selectedMinute = minute) }
    }

    fun saveGoal() {
        launchWithLoading {
            // Save logic here
            showSuccessMessage("Daily goal updated to ${currentState.selectedHour}h ${currentState.selectedMinute}m")
        }
    }
}

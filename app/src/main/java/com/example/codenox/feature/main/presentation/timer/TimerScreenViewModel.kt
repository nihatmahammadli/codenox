package com.example.codenox.feature.main.presentation.timer

import com.example.codenox.core.designsystem.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TimerScreenViewModel @Inject constructor() : BaseViewModel<TimerScreenUiState>() {
    override fun getInitialUiState(): TimerScreenUiState = TimerScreenUiState()

    fun toggleTimer() {
        updateState { it.copy(isRunning = !it.isRunning) }
    }

    fun resetTimer() {
        updateState { it.copy(isRunning = false, progress = 1f, remainingTime = "${it.focusDuration}:00") }
    }

    fun skipSession() {
        updateState { 
            val nextSession = if (it.currentSession < it.totalSessions) it.currentSession + 1 else 1
            it.copy(currentSession = nextSession)
        }
    }

    fun updateFocusDuration(delta: Int) {
        updateState { it.copy(focusDuration = (it.focusDuration + delta).coerceAtLeast(1)) }
    }

    fun updateShortBreak(delta: Int) {
        updateState { it.copy(shortBreakDuration = (it.shortBreakDuration + delta).coerceAtLeast(1)) }
    }

    fun updateLongBreak(delta: Int) {
        updateState { it.copy(longBreakDuration = (it.longBreakDuration + delta).coerceAtLeast(1)) }
    }
}

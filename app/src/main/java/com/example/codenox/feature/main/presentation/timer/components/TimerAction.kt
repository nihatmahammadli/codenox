package com.example.codenox.feature.main.presentation.timer.components

sealed interface TimerAction {
    data object OnBackClick : TimerAction
    data object OnSettingsClick : TimerAction
    data object OnResetClick : TimerAction
    data object OnToggleClick : TimerAction
    data object OnSkipClick : TimerAction
    data class OnFocusDurationChange(val delta: Int) : TimerAction
    data class OnShortBreakChange(val delta: Int) : TimerAction
    data class OnLongBreakChange(val delta: Int) : TimerAction
}

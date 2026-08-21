package com.example.codenox.feature.main.presentation.timer

data class TimerScreenUiState(
    val remainingTime: String = "25:00",
    val progress: Float = 0.75f,
    val timerLabel: String = "FOCUS TIME",
    val isRunning: Boolean = false,
    val currentSession: Int = 1,
    val totalSessions: Int = 4,
    val currentlyStudying: String = "Activities and Intents",
    val focusDuration: Int = 25,
    val shortBreakDuration: Int = 5,
    val longBreakDuration: Int = 15,
    val todaySessions: Int = 3,
    val todayFocusedTime: String = "1h 15m"
)

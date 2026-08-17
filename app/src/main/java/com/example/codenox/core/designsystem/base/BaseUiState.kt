package com.example.codenox.core.designsystem.base

import androidx.compose.runtime.Immutable

@Immutable
data class BaseUiState (
    val loadStates: LoadStates = LoadStates.Idle,
    val userMessageState: UserMessageState? = null
)
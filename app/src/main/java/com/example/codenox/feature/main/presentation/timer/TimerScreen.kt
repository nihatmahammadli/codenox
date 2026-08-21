package com.example.codenox.feature.main.presentation.timer

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.timer.components.TimerAction
import com.example.codenox.feature.main.presentation.timer.components.TimerScreenContent

@Composable
fun TimerScreen(
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    BaseScreen<TimerScreenUiState, TimerScreenViewModel> { uiState, viewModel ->
        TimerScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    TimerAction.OnBackClick -> onBackClick()
                    TimerAction.OnSettingsClick -> onSettingsClick()
                    TimerAction.OnResetClick -> viewModel.resetTimer()
                    TimerAction.OnToggleClick -> viewModel.toggleTimer()
                    TimerAction.OnSkipClick -> viewModel.skipSession()
                    is TimerAction.OnFocusDurationChange -> viewModel.updateFocusDuration(action.delta)
                    is TimerAction.OnShortBreakChange -> viewModel.updateShortBreak(action.delta)
                    is TimerAction.OnLongBreakChange -> viewModel.updateLongBreak(action.delta)
                }
            }
        )
    }
}

@Preview
@Composable
fun TimerScreenPreview() {
    CodeNoxTheme {
        TimerScreen(onBackClick = {}, onSettingsClick = {})
    }
}

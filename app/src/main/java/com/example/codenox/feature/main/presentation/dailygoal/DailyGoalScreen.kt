package com.example.codenox.feature.main.presentation.dailygoal

import androidx.compose.runtime.Composable
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.feature.main.presentation.dailygoal.components.DailyGoalAction
import com.example.codenox.feature.main.presentation.dailygoal.components.DailyGoalScreenContent

@Composable
fun DailyGoalScreen(
    onBackClick: () -> Unit
) {
    BaseScreen<DailyGoalUiState, DailyGoalViewModel> { uiState, viewModel ->
        DailyGoalScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    DailyGoalAction.OnBackClick -> onBackClick()
                    DailyGoalAction.OnSaveClick -> viewModel.saveGoal()
                    is DailyGoalAction.OnHourChange -> viewModel.onHourChange(action.hour)
                    is DailyGoalAction.OnMinuteChange -> viewModel.onMinuteChange(action.minute)
                }
            }
        )
    }
}

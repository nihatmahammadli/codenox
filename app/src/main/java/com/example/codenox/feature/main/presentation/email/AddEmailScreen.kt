package com.example.codenox.feature.main.presentation.email

import androidx.compose.runtime.Composable
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.feature.main.presentation.email.components.AddEmailAction
import com.example.codenox.feature.main.presentation.email.components.AddEmailScreenContent

@Composable
fun AddEmailScreen(
    onBackClick: () -> Unit
) {
    BaseScreen<AddEmailUiState, AddEmailViewModel> { uiState, viewModel ->
        AddEmailScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    AddEmailAction.OnBackClick -> onBackClick()
                    AddEmailAction.OnSaveClick -> viewModel.saveEmail()
                    is AddEmailAction.OnEmailChange -> viewModel.onEmailChange(action.email)
                }
            }
        )
    }
}

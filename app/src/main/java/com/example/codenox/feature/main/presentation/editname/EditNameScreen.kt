package com.example.codenox.feature.main.presentation.editname

import androidx.compose.runtime.Composable
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.feature.main.presentation.editname.components.EditNameAction
import com.example.codenox.feature.main.presentation.editname.components.EditNameScreenContent

@Composable
fun EditNameScreen(
    onBackClick: () -> Unit
) {
    BaseScreen<EditNameUiState, EditNameViewModel> { uiState, viewModel ->
        EditNameScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    EditNameAction.OnBackClick -> onBackClick()
                    EditNameAction.OnSaveClick -> viewModel.saveChanges()
                    is EditNameAction.OnFullNameChange -> viewModel.onFullNameChange(action.value)
                    is EditNameAction.OnNicknameChange -> viewModel.onNicknameChange(action.value)
                }
            }
        )
    }
}

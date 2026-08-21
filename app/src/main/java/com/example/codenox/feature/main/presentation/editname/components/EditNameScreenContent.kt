package com.example.codenox.feature.main.presentation.editname.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.feature.main.presentation.editname.EditNameUiState

@Composable
fun EditNameScreenContent(
    uiState: EditNameUiState,
    onAction: (EditNameAction) -> Unit,
    modifier: Modifier = Modifier
) {
    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .statusBarsPadding()
                .padding(top = 16.dp, bottom = 32.dp)
        ) {
            EditNameHeader { onAction(EditNameAction.OnBackClick) }

            EditNameBody(
                fullName = uiState.fullName,
                onFullNameChange = { onAction(EditNameAction.OnFullNameChange(it)) },
                nickname = uiState.nickname,
                onNicknameChange = { onAction(EditNameAction.OnNicknameChange(it)) },
                onSaveClick = { onAction(EditNameAction.OnSaveClick) },
                isButtonEnabled = uiState.isButtonEnabled
            )
        }
    }
}

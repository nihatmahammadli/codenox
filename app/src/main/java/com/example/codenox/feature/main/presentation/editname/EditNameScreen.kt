package com.example.codenox.feature.main.presentation.editname

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.feature.main.presentation.editname.components.EditNameBody
import com.example.codenox.feature.main.presentation.editname.components.EditNameHeader

@Composable
fun EditNameScreen(
    onBackClick: () -> Unit
) {
    BaseScreen<EditNameUiState, EditNameViewModel> { uiState, viewModel ->
        CodeNoxBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .statusBarsPadding()
                    .padding(top = 16.dp, bottom = 32.dp)
            ) {
                EditNameHeader(onBackClick)

                EditNameBody(
                    fullName = uiState.fullName,
                    onFullNameChange = viewModel::onFullNameChange,
                    nickname = uiState.nickname,
                    onNicknameChange = viewModel::onNicknameChange,
                    onSaveClick = viewModel::saveChanges,
                    isButtonEnabled = uiState.isButtonEnabled
                )
            }
        }
    }
}

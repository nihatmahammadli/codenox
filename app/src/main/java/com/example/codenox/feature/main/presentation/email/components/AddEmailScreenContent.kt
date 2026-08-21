package com.example.codenox.feature.main.presentation.email.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.feature.main.presentation.email.AddEmailUiState

@Composable
fun AddEmailScreenContent(
    uiState: AddEmailUiState,
    onAction: (AddEmailAction) -> Unit,
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
            AddEmailHeader { onAction(AddEmailAction.OnBackClick) }

            AddEmailBody(
                email = uiState.email,
                onEmailChange = { onAction(AddEmailAction.OnEmailChange(it)) },
                onSaveClick = { onAction(AddEmailAction.OnSaveClick) },
                isButtonEnabled = uiState.isButtonEnabled,
                modifier = Modifier.padding(horizontal = 0.dp)
            )
        }
    }
}

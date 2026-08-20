package com.example.codenox.feature.main.presentation.email

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.feature.main.presentation.email.components.AddEmailBody
import com.example.codenox.feature.main.presentation.email.components.AddEmailHeader

@Composable
fun AddEmailScreen(
    onBackClick: () -> Unit
) {
    BaseScreen<AddEmailUiState, AddEmailViewModel> { uiState, viewModel ->
        CodeNoxBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .statusBarsPadding()
                    .padding(top = 16.dp, bottom = 32.dp)
            ) {
                AddEmailHeader(onBackClick)

                AddEmailBody(
                    email = uiState.email,
                    onEmailChange = viewModel::onEmailChange,
                    onSaveClick = viewModel::saveEmail,
                    isButtonEnabled = uiState.isButtonEnabled,
                    modifier = Modifier.padding(horizontal = 0.dp) // Body already inside 16.dp container
                )
            }
        }
    }
}

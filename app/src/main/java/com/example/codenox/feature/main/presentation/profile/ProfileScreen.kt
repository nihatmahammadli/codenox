package com.example.codenox.feature.main.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.feature.main.presentation.profile.components.ProfileAction
import com.example.codenox.feature.main.presentation.profile.components.ProfileScreenContent

@Composable
fun ProfileScreen(
    onSettingsClick: () -> Unit = {},
    onLearnClick: () -> Unit = {},
    onSavedClick: () -> Unit = {}
) {
    BaseScreen<ProfileUiState, ProfileViewModel> { uiState, viewModel ->
        ProfileScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    ProfileAction.OnSettingsClick -> onSettingsClick()
                    ProfileAction.OnLearnClick -> onLearnClick()
                    ProfileAction.OnSavedClick -> onSavedClick()
                }
            }
        )
    }
}

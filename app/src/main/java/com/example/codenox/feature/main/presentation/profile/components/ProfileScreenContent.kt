package com.example.codenox.feature.main.presentation.profile.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.feature.main.presentation.profile.ProfileUiState

@Composable
fun ProfileScreenContent(
    uiState: ProfileUiState,
    onAction: (ProfileAction) -> Unit,
    modifier: Modifier = Modifier
) {
    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            ProfileHeader(onSettingsClick = { onAction(ProfileAction.OnSettingsClick) })
            Spacer(modifier = Modifier.height(24.dp))
            ProfileUserCard(state = uiState)
            Spacer(modifier = Modifier.height(24.dp))
            StatsRow(onSavedClick = { onAction(ProfileAction.OnSavedClick) })
            Spacer(modifier = Modifier.height(32.dp))
            LearningProgressSection(onClick = { onAction(ProfileAction.OnLearnClick) })
            Spacer(modifier = Modifier.height(32.dp))
            RecentActivitySection()
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

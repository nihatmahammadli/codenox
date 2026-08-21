package com.example.codenox.feature.main.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.feature.main.presentation.profile.components.LearningProgressSection
import com.example.codenox.feature.main.presentation.profile.components.ProfileHeader
import com.example.codenox.feature.main.presentation.profile.components.ProfileUserCard
import com.example.codenox.feature.main.presentation.profile.components.RecentActivitySection
import com.example.codenox.feature.main.presentation.profile.components.StatsRow

@Composable
fun ProfileScreen(
    onSettingsClick: () -> Unit = {},
    onLearnClick: () -> Unit = {},
    onSavedClick: () -> Unit = {}
) {
    BaseScreen<ProfileUiState, ProfileViewModel> { uiState, viewModel ->
        CodeNoxBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                ProfileHeader(onSettingsClick = onSettingsClick)
                Spacer(modifier = Modifier.height(24.dp))
                ProfileUserCard(state = uiState)
                Spacer(modifier = Modifier.height(24.dp))
                StatsRow(onSavedClick = onSavedClick)
                Spacer(modifier = Modifier.height(32.dp))
                LearningProgressSection(onClick = onLearnClick)
                Spacer(modifier = Modifier.height(32.dp))
                RecentActivitySection()
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}
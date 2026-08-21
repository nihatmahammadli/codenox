package com.example.codenox.feature.main.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.home.components.HomeAction
import com.example.codenox.feature.main.presentation.home.components.HomeScreenContent

@Composable
fun HomeScreen(
    onLearnClick: () -> Unit = {},
    onTrophiesClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    onTimerClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    BaseScreen<HomeUiState, HomeViewModel> { uiState, viewModel ->
        HomeScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    HomeAction.OnLearnClick -> onLearnClick()
                    HomeAction.OnProfileClick -> onProfileClick()
                    HomeAction.OnTimerClick -> onTimerClick()
                    HomeAction.OnTrophiesClick -> onTrophiesClick()
                }
            },
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0B0D0C)
@Composable
private fun HomeScreenPreview() {
    CodeNoxTheme {
        HomeScreen()
    }
}

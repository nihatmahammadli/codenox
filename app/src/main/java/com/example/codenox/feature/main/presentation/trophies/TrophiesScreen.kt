package com.example.codenox.feature.main.presentation.trophies

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.trophies.components.TrophiesAction
import com.example.codenox.feature.main.presentation.trophies.components.TrophiesScreenContent

@Composable
fun TrophiesScreen(
    modifier: Modifier = Modifier
) {
    BaseScreen<TrophiesUiState, TrophiesViewModel> { uiState, viewModel ->
        TrophiesScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    TrophiesAction.OnViewAllBadgesClick -> { }
                }
            },
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0B0D0C)
@Composable
private fun TrophiesScreenPreview() {
    CodeNoxTheme {
        TrophiesScreen()
    }
}

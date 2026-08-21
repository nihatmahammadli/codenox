package com.example.codenox.feature.main.presentation.learn

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.learn.components.LearnAction
import com.example.codenox.feature.main.presentation.learn.components.LearnScreenContent

@Composable
fun LearnScreen(
    modifier: Modifier = Modifier,
    onResumeClick: () -> Unit = {},
    onSavedClick: () -> Unit = {}
) {
    BaseScreen<LearnUiState, LearnViewModel> { uiState, viewModel ->
        LearnScreenContent(
            uiState = uiState,
            onAction = { action ->
                when (action) {
                    LearnAction.OnResumeClick -> onResumeClick()
                    LearnAction.OnSavedClick -> onSavedClick()
                    is LearnAction.OnCategorySelected -> viewModel.onCategorySelected(action.category)
                    is LearnAction.OnSearchQueryChange -> viewModel.onSearchQueryChange(action.query)
                }
            },
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF0B0D0C)
@Composable
private fun LearnScreenPreview() {
    CodeNoxTheme {
        LearnScreen()
    }
}

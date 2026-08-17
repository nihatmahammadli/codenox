package com.example.codenox.core.designsystem.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.codenox.core.designsystem.components.LoadingOverlay
import com.example.codenox.navigation.LocalNavigationManager
import com.example.codenox.navigation.NavigationManager
import kotlinx.coroutines.flow.collectLatest

@Composable
inline fun <UiState, reified ViewModelType : BaseViewModel<UiState>> BaseScreen(
    viewModel: ViewModelType = hiltViewModel(),
    navigationManager: NavigationManager = LocalNavigationManager.current,
    content: @Composable (uiState: UiState, viewModel: ViewModelType) -> Unit
) {
    val baseUiState by viewModel.baseUiState.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.navigationEvent.collectLatest { event ->
            when (event) {
                is NavigationEvent.NavigateTo -> {
                    navigationManager.navigateTo(
                        screen = event.screen,
                        popUpTo = event.popUpTo,
                        inclusive = event.inclusive,
                        clearBackStack = event.clearBackStack,
                        launchSingleTop = event.launchSingleTop
                    )
                }

                is NavigationEvent.Back -> {
                    navigationManager.navigateBack()
                }
            }
        }
    }

    LaunchedEffect(baseUiState.userMessageState) {
        baseUiState.userMessageState?.let { state ->
            val message = when (state) {
                is UserMessageState.Success -> state.message
                is UserMessageState.Error -> state.message
                is UserMessageState.Warning -> state.message
                is UserMessageState.Info -> state.message
            } ?: "Bir xəta baş verdi"
            
            snackbarHostState.showSnackbar(message)
            viewModel.dismissUserMessageState()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        content(uiState, viewModel)

        if (baseUiState.loadStates.isLoading) {
            LoadingOverlay()
        }

        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

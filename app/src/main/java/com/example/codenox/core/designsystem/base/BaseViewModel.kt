package com.example.codenox.core.designsystem.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codenox.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.coroutines.cancellation.CancellationException

abstract class BaseViewModel<UiState> : ViewModel() {

    // region State
    private val _baseUiState = MutableStateFlow(BaseUiState())
    val baseUiState: StateFlow<BaseUiState> = _baseUiState.asStateFlow()

    private val _uiState by lazy { MutableStateFlow(getInitialUiState()) }
    val uiState: StateFlow<UiState> by lazy { _uiState.asStateFlow() }

    abstract fun getInitialUiState(): UiState

    protected val currentState: UiState
        get() = _uiState.value

    protected fun updateState(update: (UiState) -> UiState) {
        _uiState.update(update)
    }
    // endregion

    // region Navigation
    private val _navigationEvent = MutableSharedFlow<NavigationEvent>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val navigationEvent = _navigationEvent.asSharedFlow()

    protected fun navigateTo(
        screen: Screen,
        popUpTo: Screen? = null,
        inclusive: Boolean = false,
        clearBackStack: Boolean = false,
        launchSingleTop: Boolean = false
    ) {
        viewModelScope.launch {
            _navigationEvent.emit(
                NavigationEvent.NavigateTo(
                    screen = screen,
                    popUpTo = popUpTo,
                    inclusive = inclusive,
                    clearBackStack = clearBackStack,
                    launchSingleTop = launchSingleTop
                )
            )
        }
    }

    fun navigateBack() {
        viewModelScope.launch {
            _navigationEvent.emit(NavigationEvent.Back)
        }
    }
    // endregion

    // region Loading
    protected fun setLoading(isLoading: Boolean) {
        _baseUiState.update { it.copy(loadStates = if (isLoading) LoadStates.Loading else LoadStates.Idle) }
    }
    // endregion

    // region User Messages
    protected fun showSuccessMessage(message: String? = null, title: String? = null) {
        showUserMessage(UserMessageState.Success(message = message, title = title))
    }

    protected fun showErrorMessage(message: String? = null, title: String? = null) {
        showUserMessage(UserMessageState.Error(message = message, title = title))
    }

    fun showNoInternetError() {
        showErrorMessage(message = "İnternet bağlantısı yoxdur. Zəhmət olmasa şəbəkəni yoxlayın.")
    }

    open fun dismissUserMessageState() {
        _baseUiState.update { it.copy(userMessageState = null) }
    }

    private fun showUserMessage(state: UserMessageState) {
        _baseUiState.update { it.copy(userMessageState = state) }
    }
    // endregion

    // region Execution Helpers
    protected fun launchWithLoading(
        showLoading: Boolean = true,
        onError: ((Throwable) -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit
    ): Job {
        return viewModelScope.launch {
            try {
                if (showLoading) setLoading(true)
                dismissUserMessageState()
                withContext(Dispatchers.IO) {
                    block()
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                if (onError != null) {
                    onError(e)
                } else {
                    handleException(e)
                }
            } finally {
                if (showLoading) setLoading(false)
            }
        }
    }

    private fun handleException(e: Exception) {
        when (e) {
            is UnknownHostException, is ConnectException, is SocketTimeoutException -> showNoInternetError()
            else -> showErrorMessage(message = e.localizedMessage ?: "Gözlənilməz xəta baş verdi.")
        }
    }
    // endregion
}

sealed class NavigationEvent {
    data class NavigateTo(
        val screen: Screen,
        val popUpTo: Screen? = null,
        val inclusive: Boolean = false,
        val clearBackStack: Boolean = false,
        val launchSingleTop: Boolean = false
    ) : NavigationEvent()

    data object Back : NavigationEvent()
}

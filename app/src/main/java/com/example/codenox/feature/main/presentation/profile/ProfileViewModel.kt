package com.example.codenox.feature.main.presentation.profile

import androidx.lifecycle.viewModelScope
import com.example.codenox.core.designsystem.base.BaseViewModel
import com.example.codenox.domain.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: ProfileRepository
) : BaseViewModel<ProfileUiState>() {

    override fun getInitialUiState() = ProfileUiState()

    init {
        loadProfile()
    }

    fun loadProfile() {
        viewModelScope.launch {
            updateState {
                it.copy(isLoading = false)
            }

            runCatching {
                repository.getCurrentProfile()
            }.onSuccess { profile ->
                updateState {
                    it.copy(
                        isLoading = false,
                        profile = profile
                    )
                }
            }.onFailure { throwable ->
                updateState {
                    it.copy(
                        isLoading = false,
                        errorMessage = throwable.message
                    )
                }
            }
        }
    }
}

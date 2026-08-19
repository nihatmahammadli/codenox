package com.example.codenox.feature.main.presentation.settings

import androidx.lifecycle.viewModelScope
import com.example.codenox.core.designsystem.base.BaseViewModel
import com.example.codenox.domain.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : BaseViewModel<SettingsUiState>(){

    override fun getInitialUiState() = SettingsUiState()

    init {
        loadProfileInfo()
    }

     fun loadProfileInfo(){
        viewModelScope.launch {
            updateState {
                it.copy(isLoading = false)
            }

            runCatching {
                profileRepository.getCurrentProfile()
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
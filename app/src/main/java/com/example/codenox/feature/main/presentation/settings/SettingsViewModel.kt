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
            updateState { it.copy(isLoading = true) }

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

    fun showThemeModal() {
        updateState { it.copy(isThemeModalVisible = true) }
    }

    fun hideThemeModal() {
        updateState { it.copy(isThemeModalVisible = false) }
    }

    fun onThemeSelected(theme: ThemeType) {
        updateState { it.copy(selectedTheme = theme, isThemeModalVisible = false) }
        // TODO: Persist theme change
    }

    fun showLanguageModal() {
        updateState { it.copy(isLanguageModalVisible = true) }
    }

    fun hideLanguageModal() {
        updateState { it.copy(isLanguageModalVisible = false) }
    }

    fun onLanguageSelected(language: LanguageType) {
        updateState { it.copy(selectedLanguage = language, isLanguageModalVisible = false) }
        // TODO: Persist language change
    }
}
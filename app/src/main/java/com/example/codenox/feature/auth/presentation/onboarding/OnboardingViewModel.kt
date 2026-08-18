package com.example.codenox.feature.auth.presentation.onboarding

import com.example.codenox.core.util.Util
import com.example.codenox.core.designsystem.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor() : BaseViewModel<OnboardingUiState>() {

    override fun getInitialUiState() = OnboardingUiState()

    fun onNameChange(name: String) {
        updateState { it.copy(name = name) }
        validate()
    }

    fun onNicknameChange(nickname: String) {
        updateState { it.copy(nickname = nickname) }
        validate()
    }

    fun onLevelSelected(level: Int) {
        updateState { it.copy(selectedLevel = level) }
        validate()
    }

    fun onPageChanged(page: Int) {
        updateState { it.copy(currentPage = page) }
        validate()
    }

    private fun validate() {
        val state = currentState
        val isEnabled = when (state.currentPage) {
            0 -> Util.isValid(state.name) && Util.isValid(state.nickname)
            1 -> state.selectedLevel != null
            else -> false
        }
        updateState { it.copy(isButtonEnabled = isEnabled) }
    }
    
    fun getFinalData(): OnboardingData {
        val state = currentState
        return OnboardingData(
            name = state.name,
            nickname = state.nickname,
            selectedLevel = state.selectedLevel ?: 1
        )
    }
}

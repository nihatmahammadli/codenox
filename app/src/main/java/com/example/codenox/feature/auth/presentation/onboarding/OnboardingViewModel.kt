package com.example.codenox.feature.auth.presentation.onboarding

import androidx.lifecycle.viewModelScope
import com.example.codenox.core.util.Util
import com.example.codenox.core.designsystem.base.BaseViewModel
import com.example.codenox.domain.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : BaseViewModel<OnboardingUiState>() {

    override fun getInitialUiState() = OnboardingUiState()

    private val _effect = Channel<OnboardingEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()


    fun onAction(action: OnboardingAction){
        when(action){
            is OnboardingAction.FullNameChanged -> {
                updateState { it.copy(
                    fullName = action.value,
                    fullNameError = null
                ) }
                updateButtonState()
            }

            is OnboardingAction.NicknameChanged -> {
                updateState { it.copy(
                    nickname = action.value,
                    nicknameError = null
                ) }
                updateButtonState()
            }

            is OnboardingAction.LevelSelected -> {
                updateState { it.copy(
                    experienceLevel = action.level
                ) }
                updateButtonState()
            }

            is OnboardingAction.PageChanged -> {
                updateState { it.copy(
                    currentStep = action.page
                ) }
                updateButtonState()
            }
            OnboardingAction.CompleteOnboarding -> {
                completeOnboarding()
            }
        }
    }
    private fun updateButtonState() {

        val state = uiState.value

        val enabled =
            when (state.currentStep) {

                0 -> {
                    state.fullName.trim().length >= 2 &&
                            state.nickname.trim().length >= 3
                }

                1 -> {
                    state.experienceLevel != null
                }

                else -> false
            }

        updateState {
            it.copy(
                isButtonEnabled = enabled
            )
        }
    }


    private fun completeOnboarding(){
        val currentState = uiState.value

        val level = currentState.experienceLevel ?: return

        viewModelScope.launch {
            updateState {
                it.copy(
                    isLoading = true,
                    errorMessage = null
                )
            }
            runCatching {
                profileRepository.createProfile(
                    nickname = currentState.nickname.trim(),
                    fullName = currentState.fullName.trim(),
                    experienceLevel = level
                )
            }.onSuccess {
                updateState {
                    it.copy(isLoading = false)
                }
            }.onFailure { throwable ->
                updateState {
                    it.copy(
                        isLoading = false,
                        errorMessage = throwable.message ?: "Something went wrong",
                    )
                }
            }
        }
    }

}

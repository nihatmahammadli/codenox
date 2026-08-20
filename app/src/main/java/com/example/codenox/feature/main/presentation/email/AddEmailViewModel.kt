package com.example.codenox.feature.main.presentation.email

import com.example.codenox.core.util.Util
import com.example.codenox.core.designsystem.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEmailViewModel @Inject constructor() : BaseViewModel<AddEmailUiState>() {
    override fun getInitialUiState(): AddEmailUiState = AddEmailUiState()

    fun onEmailChange(email: String) {
        updateState { it.copy(
            email = email,
            isButtonEnabled = Util.isValid(email) && email.contains("@") && email.contains(".")
        ) }
    }
    
    fun saveEmail() {
        launchWithLoading {
            // Logic to save email to Supabase will be here later
            showSuccessMessage("Verification link sent to ${currentState.email}")
        }
    }
}

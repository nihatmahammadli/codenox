package com.example.codenox.feature.main.presentation.editname

import com.example.codenox.core.util.Util
import com.example.codenox.core.designsystem.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditNameViewModel @Inject constructor() : BaseViewModel<EditNameUiState>() {
    override fun getInitialUiState(): EditNameUiState = EditNameUiState()

    fun onFullNameChange(name: String) {
        updateState { it.copy(
            fullName = name,
            isButtonEnabled = Util.isValid(name) && Util.isValid(it.nickname)
        ) }
    }

    fun onNicknameChange(nickname: String) {
        updateState { it.copy(
            nickname = nickname,
            isButtonEnabled = Util.isValid(it.fullName) && Util.isValid(nickname)
        ) }
    }

    fun saveChanges() {
        launchWithLoading {
            // Backend logic will be added later
            showSuccessMessage("Profil məlumatları uğurla yeniləndi")
        }
    }
}

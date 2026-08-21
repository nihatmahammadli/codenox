package com.example.codenox.feature.main.presentation.editname.components

sealed interface EditNameAction {
    data object OnBackClick : EditNameAction
    data object OnSaveClick : EditNameAction
    data class OnFullNameChange(val value: String) : EditNameAction
    data class OnNicknameChange(val value: String) : EditNameAction
}

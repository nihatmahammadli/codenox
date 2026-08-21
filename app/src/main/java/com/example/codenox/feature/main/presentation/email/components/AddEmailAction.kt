package com.example.codenox.feature.main.presentation.email.components

sealed interface AddEmailAction {
    data object OnBackClick : AddEmailAction
    data object OnSaveClick : AddEmailAction
    data class OnEmailChange(val email: String) : AddEmailAction
}

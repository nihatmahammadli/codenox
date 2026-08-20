package com.example.codenox.feature.main.presentation.editname

data class EditNameUiState(
    val fullName: String = "",
    val nickname: String = "",
    val isButtonEnabled: Boolean = false,
    val isLoading: Boolean = false
)

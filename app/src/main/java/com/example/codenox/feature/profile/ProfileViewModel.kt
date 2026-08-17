package com.example.codenox.feature.profile

import com.example.codenox.core.designsystem.base.BaseViewModel
import com.example.codenox.data.repository.ProfileRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : BaseViewModel<ProfileUiState>() {
    private val repository = ProfileRepository()

    override fun getInitialUiState() = ProfileUiState()

    init {
        loadProfile()
    }

    fun loadProfile() {
        launchWithLoading {
            runCatching {
                repository.getProfiles()
            }.onSuccess { profiles ->
                updateState { it.copy(profile = profiles.firstOrNull()) }
            }.onFailure {
                it.printStackTrace()
                showErrorMessage("Profil məlumatlarını yükləmək mümkün olmadı")
            }
        }
    }
}

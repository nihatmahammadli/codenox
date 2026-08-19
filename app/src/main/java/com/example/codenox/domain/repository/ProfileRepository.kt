package com.example.codenox.domain.repository

import com.example.codenox.domain.model.ExperienceLevel
import com.example.codenox.domain.model.Profile

interface ProfileRepository {
    suspend fun createProfile(
        nickname: String,
        fullName: String,
        experienceLevel: ExperienceLevel
    )

    suspend fun getCurrentProfile(): Profile?
}
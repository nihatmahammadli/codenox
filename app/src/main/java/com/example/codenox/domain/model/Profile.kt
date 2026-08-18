package com.example.codenox.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id: String,
    val nickname: String,
    @SerialName("full_name")
    val fullName: String,
    @SerialName("experience_level")
    val experienceLevel: ExperienceLevel
)

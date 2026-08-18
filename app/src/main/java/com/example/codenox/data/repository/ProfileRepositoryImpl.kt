package com.example.codenox.data.repository

import com.example.codenox.domain.model.ExperienceLevel
import com.example.codenox.domain.model.Profile
import com.example.codenox.domain.repository.ProfileRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.from
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val supabase: SupabaseClient
) : ProfileRepository {
    override suspend fun createProfile(
        nickname: String,
        fullName: String,
        experienceLevel: ExperienceLevel
    ) {
        var user = supabase.auth.currentUserOrNull()

        if (user == null) {
            supabase.auth.signInAnonymously()
            user = supabase.auth.currentUserOrNull()
        }

        var userId = requireNotNull(user?.id) {
            "Supabase user could not be created"
        }

        val profile = Profile(
            id = userId,
            nickname = nickname,
            fullName = fullName,
            experienceLevel = experienceLevel
        )

        supabase
            .from("profiles")
            .upsert(profile)
    }

    override suspend fun getCurrentProfile(): Profile? {
        val user = supabase.auth.currentUserOrNull() ?: return null

        return supabase
            .from("profiles")
            .select {
                filter {
                    eq("id", user.id)
                }
            }
            .decodeList<Profile>()
            .firstOrNull()
    }

}
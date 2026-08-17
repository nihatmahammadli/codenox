package com.example.codenox.data.repository

import com.example.codenox.core.network.supabase
import com.example.codenox.domain.model.Profile
import io.github.jan.supabase.postgrest.from

class ProfileRepository {
    suspend fun getProfiles(): List<Profile> {
        return supabase
            .from("profiles")
            .select()
            .decodeList<Profile>()
    }
}
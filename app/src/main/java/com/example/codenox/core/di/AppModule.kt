package com.example.codenox.core.di

import com.example.codenox.domain.repository.ProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.BuildConfig
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.annotations.SupabaseInternal
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @OptIn(SupabaseInternal::class)
    @Provides
    @Singleton
    fun provideSupabaseClient() : SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = com.example.codenox.BuildConfig.SUPABASE_URL,
            supabaseKey = com.example.codenox.BuildConfig.SUPABASE_PUBLISHABLE_KEY
        ) {
            install(Postgrest)
            install(Auth)
        }
    }

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class RepositoryModule(
        implementation: ProfileRepository
    ): ProfileRepository
}

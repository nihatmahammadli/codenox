package com.example.codenox

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CodeNoxApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}

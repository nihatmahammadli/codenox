package com.example.codenox.navigation

sealed class Screen(val route: String) {
    data object Splash : Screen("splash")
    data object Onboarding : Screen("onboarding")
    data object Main : Screen("main")
    data object Home : Screen("home")
    data object Learn : Screen("learn")
    data object Trophies : Screen("trophies")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    
    // Example for parameterized routes
    data class Detail(val id: String) : Screen("detail/$id") {
        companion object {
            const val ROUTE = "detail/{id}"
            fun createRoute(id: String) = "detail/$id"
        }
    }
}

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
    data object AddEmail:  Screen("addEmail")
    data object EditName : Screen("edit_name")
    data object DailyGoal : Screen("daily_goal")
    data object Lesson : Screen("lesson")
    data object Saved : Screen("saved")
    data object Timer : Screen("timer")
    
    // Example for parameterized routes
    data class Detail(val id: String) : Screen("detail/$id") {
        companion object {
            const val ROUTE = "detail/{id}"
            fun createRoute(id: String) = "detail/$id"
        }
    }
}

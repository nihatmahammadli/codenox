package com.example.codenox.core.navigation

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Learn: Routes("learn")
    data object Lab: Routes("lab")
    data object Profile: Routes("profile")
}

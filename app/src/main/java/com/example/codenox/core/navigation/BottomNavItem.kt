package com.example.codenox.core.navigation

sealed class BottomNavItem(val route: String, val title: String) {
    object Home : BottomNavItem("home", "Home")
}

package com.example.codenox.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Stable
interface NavigationManager {
    fun navigateTo(
        screen: Screen,
        popUpTo: Screen? = null,
        inclusive: Boolean = false,
        clearBackStack: Boolean = false,
        launchSingleTop: Boolean = false
    )
    fun navigateBack(): Boolean
}

class NavigationManagerImpl(
    private val navController: NavController
): NavigationManager {
    override fun navigateTo(
        screen: Screen,
        popUpTo: Screen?,
        inclusive: Boolean,
        clearBackStack: Boolean,
        launchSingleTop: Boolean
    ) {
        navController.navigate(screen.route) {
            if (clearBackStack) {
                popUpTo(0) { this.inclusive = true }
            } else if (popUpTo != null) {
                popUpTo(popUpTo.route) { this.inclusive = inclusive }
            }
            this.launchSingleTop = launchSingleTop
        }
    }

    override fun navigateBack(): Boolean = navController.navigateUp()
}

val LocalNavigationManager = staticCompositionLocalOf<NavigationManager> {
    error("No NavigationManager provided")
}

@Composable
fun rememberNavigationManager(navController: NavHostController): NavigationManager {
    return remember(navController) { NavigationManagerImpl(navController) }
}

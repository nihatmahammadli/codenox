package com.example.codenox.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.codenox.core.designsystem.components.BottomBarTab
import com.example.codenox.core.designsystem.components.NavigationBottomBar
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.home.HomeScreen
import com.example.codenox.feature.lab.LabScreen
import com.example.codenox.feature.learn.LearnScreen
import com.example.codenox.feature.profile.ProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val currentTab = remember(currentRoute) {
        when (currentRoute) {
            Routes.Home.route -> BottomBarTab.HOME
            Routes.Learn.route -> BottomBarTab.LEARN
            Routes.Lab.route -> BottomBarTab.TROPHIES
            Routes.Profile.route -> BottomBarTab.PROFILE
            else -> BottomBarTab.HOME
        }
    }

    // Memoize navigation callbacks to prevent unnecessary recompositions
    val onNavigateToHome = remember(navController) {
        {
            if (currentRoute != Routes.Home.route) {
                navController.navigate(Routes.Home.route) {
                    popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

    val onNavigateToLearn = remember(navController) {
        {
            if (currentRoute != Routes.Learn.route) {
                navController.navigate(Routes.Learn.route) {
                    popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

    val onNavigateToTrophies = remember(navController) {
        {
            if (currentRoute != Routes.Lab.route) {
                navController.navigate(Routes.Lab.route) {
                    popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

    val onNavigateToProfile = remember(navController) {
        {
            if (currentRoute != Routes.Profile.route) {
                navController.navigate(Routes.Profile.route) {
                    popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }

    Scaffold(
        containerColor = CodeNoxTheme.colors.background,
        bottomBar = {
            NavigationBottomBar(
                currentTab = currentTab,
                onNavigateToHome = onNavigateToHome,
                onNavigateToLearn = onNavigateToLearn,
                onNavigateToTrophies = onNavigateToTrophies,
                onNavigateToProfile = onNavigateToProfile
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            composable(Routes.Home.route) {
                HomeScreen()
            }
            composable(Routes.Learn.route) {
                LearnScreen()
            }
            composable(Routes.Lab.route) {
                LabScreen()
            }
            composable(Routes.Profile.route) {
                ProfileScreen()
            }
        }
    }
}

package com.example.codenox.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.codenox.feature.home.HomeScreen
import com.example.codenox.feature.lab.LabScreen
import com.example.codenox.feature.learn.LearnScreen
import com.example.codenox.feature.profile.ProfileScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
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

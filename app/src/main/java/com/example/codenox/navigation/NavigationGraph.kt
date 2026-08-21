package com.example.codenox.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.codenox.feature.auth.presentation.onboarding.OnboardingScreen
import com.example.codenox.feature.auth.presentation.splash.SplashScreen
import com.example.codenox.feature.main.presentation.dailygoal.DailyGoalScreen
import com.example.codenox.feature.main.presentation.editname.EditNameScreen
import com.example.codenox.feature.main.presentation.email.AddEmailScreen
import com.example.codenox.feature.main.presentation.learn.LearnScreen
import com.example.codenox.feature.main.presentation.lesson.LessonScreen
import com.example.codenox.feature.main.presentation.saved.SavedLessonScreen
import com.example.codenox.feature.main.presentation.settings.SettingsScreen
import com.example.codenox.feature.main.presentation.timer.TimerScreen

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String = Screen.Splash.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(350)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(350)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(350)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(350)
            )
        }
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(onSplashFinished = {
                navController.navigate(Screen.Onboarding.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }

        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(onFinish = {
                navController.navigate(Screen.Main.route) {
                    popUpTo(Screen.Onboarding.route) { inclusive = true }
                }
            })
        }

        composable(route = Screen.Main.route) {
            MainScreen(
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                },
                onResumeClick = {
                    navController.navigate(Screen.Lesson.route)
                },
                onSavedClick = {
                    navController.navigate(Screen.Saved.route)
                },
                onTimerClick = {
                    navController.navigate(Screen.Timer.route)
                },
                onBackToHome = {
                    // Handled inside MainScreen via BackHandler
                }
            )
        }

        composable(route = Screen.Settings.route) {
            SettingsScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onEditNameClick = {
                    navController.navigate(Screen.EditName.route)
                },
                onEditEmailClick = {
                    navController.navigate(Screen.AddEmail.route)
                },
                onDailyGoalClick = {
                    navController.navigate(Screen.DailyGoal.route)
                },
                onLogoutClick = {
                    navController.navigate(Screen.Onboarding.route) {
                        popUpTo(0) { inclusive = true }
                    }
                }
            )
        }

        composable(route = Screen.AddEmail.route) {
            AddEmailScreen(
                onBackClick = {
                    navController.popBackStack()
                })
        }

        composable(route = Screen.EditName.route) {
            EditNameScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = Screen.Learn.route) {
            LearnScreen(
                onResumeClick = {
                    navController.navigate(Screen.Lesson.route) 
                }
            )
        }

        composable(route = Screen.Lesson.route) {
            LessonScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSaveClick = {

                },
                onCompleteClick = {
                }
            )
        }

        composable(route = Screen.DailyGoal.route) {
            DailyGoalScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = Screen.Saved.route) {
            SavedLessonScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onLessonClick = { lessonId ->
                    navController.navigate(Screen.Lesson.route)
                }
            )
        }

        composable(route = Screen.Timer.route) {
            TimerScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSettingsClick = {
                    navController.navigate(Screen.Settings.route)
                }
            )
        }
    }
}

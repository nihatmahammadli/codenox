package com.example.codenox.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.BottomBarTab
import com.example.codenox.core.designsystem.components.CodeNoxBottomBar
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.home.HomeScreen
import com.example.codenox.feature.learn.LearnScreen
import com.example.codenox.feature.profile.ProfileScreen
import com.example.codenox.feature.profile.SettingsScreen
import com.example.codenox.feature.trophies.TrophiesScreen
import com.example.codenox.feature.welcome.OnboardingScreen
import com.example.codenox.feature.welcome.SplashScreen
import kotlinx.coroutines.launch

@Composable
fun AppNavigation() {
    var currentScreen by rememberSaveable { mutableStateOf("splash") }

    when (currentScreen) {
        "splash" -> {
            SplashScreen(onSplashFinished = { currentScreen = "onboarding" })
        }
        "onboarding" -> {
            OnboardingScreen(onFinish = { data ->
                // Here you can send 'data' to your backend/repository
                currentScreen = "main" 
            })
        }
        "settings" -> {
            SettingsScreen(
                onBackClick = { currentScreen = "main_profile" },
                onLogoutClick = { currentScreen = "onboarding" }
            )
        }
        "main_profile" -> {
            MainScreen(
                onSettingsClick = { currentScreen = "settings" },
                initialTab = BottomBarTab.PROFILE
            )
        }
        else -> {
            MainScreen(onSettingsClick = { currentScreen = "settings" })
        }
    }
}

@Composable
fun MainScreen(
    onSettingsClick: () -> Unit,
    initialTab: BottomBarTab = BottomBarTab.HOME
) {
    val tabs = BottomBarTab.entries
    val pagerState = rememberPagerState(
        initialPage = initialTab.ordinal,
        pageCount = { tabs.size }
    )
    val scope = rememberCoroutineScope()

    val navigateToTab: (BottomBarTab) -> Unit = { tab ->
        scope.launch {
            pagerState.animateScrollToPage(tab.ordinal)
        }
    }

    Scaffold(
        containerColor = CodeNoxTheme.colors.background,
        bottomBar = {
            CodeNoxBottomBar(
                pagerState = pagerState,
                onTabSelected = { tab ->
                    navigateToTab(tab)
                }
            )
        }
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            beyondViewportPageCount = 1
        ) { page ->
            when (tabs[page]) {
                BottomBarTab.HOME -> HomeScreen(
                    onLearnClick = { navigateToTab(BottomBarTab.LEARN) },
                    onTrophiesClick = { navigateToTab(BottomBarTab.TROPHIES) },
                    onProfileClick = { navigateToTab(BottomBarTab.PROFILE) }
                )
                BottomBarTab.LEARN -> LearnScreen()
                BottomBarTab.TROPHIES -> TrophiesScreen()
                BottomBarTab.PROFILE -> ProfileScreen(
                    onSettingsClick = onSettingsClick,
                    onLearnClick = { navigateToTab(BottomBarTab.LEARN) }
                )
            }
        }
    }
}

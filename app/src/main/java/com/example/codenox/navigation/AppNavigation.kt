package com.example.codenox.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.codenox.core.designsystem.components.BottomBarTab
import com.example.codenox.core.designsystem.components.CodeNoxBottomBar
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.home.HomeScreen
import com.example.codenox.feature.main.presentation.learn.LearnScreen
import com.example.codenox.feature.main.presentation.profile.ProfileScreen
import com.example.codenox.feature.main.presentation.trophies.TrophiesScreen
import kotlinx.coroutines.launch

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val navigationManager = rememberNavigationManager(navController)

    CompositionLocalProvider(LocalNavigationManager provides navigationManager) {
        NavigationGraph(navController = navController)
    }
}

@Composable
fun MainScreen(
    onSettingsClick: () -> Unit,
    initialTab: BottomBarTab = BottomBarTab.HOME,
    onBackToHome: () -> Unit
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

    // Handle system back button inside MainScreen
    BackHandler(enabled = pagerState.currentPage != BottomBarTab.HOME.ordinal) {
        if (pagerState.currentPage != BottomBarTab.HOME.ordinal) {
            navigateToTab(BottomBarTab.HOME)
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

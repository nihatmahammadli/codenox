package com.example.codenox.core.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.BottomBarTab
import com.example.codenox.core.designsystem.components.CodeNoxBottomBar
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.home.HomeScreen
import com.example.codenox.feature.lab.LabScreen
import com.example.codenox.feature.learn.LearnScreen
import com.example.codenox.feature.profile.ProfileScreen
import kotlinx.coroutines.launch

@Composable
fun AppNavigation() {
    val tabs = BottomBarTab.entries
    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val scope = rememberCoroutineScope()

    Scaffold(
        containerColor = CodeNoxTheme.colors.background,
        bottomBar = {
            CodeNoxBottomBar(
                pagerState = pagerState,
                onTabSelected = { tab ->
                    scope.launch {
                        pagerState.animateScrollToPage(tab.ordinal)
                    }
                }
            )
        }
    ) { innerPadding ->
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            beyondViewportPageCount = 1
        ) { page ->
            when (tabs[page]) {
                BottomBarTab.HOME -> HomeScreen()
                BottomBarTab.LEARN -> LearnScreen()
                BottomBarTab.TROPHIES -> LabScreen()
                BottomBarTab.PROFILE -> ProfileScreen()
            }
        }
    }
}

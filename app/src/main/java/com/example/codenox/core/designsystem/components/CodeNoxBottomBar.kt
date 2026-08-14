package com.example.codenox.core.designsystem.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTextStyles
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

enum class BottomBarTab(
    @StringRes val titleRes: Int,
    @DrawableRes val icon: Int
) {
    HOME(R.string.bottom_bar_home, R.drawable.ic_home),
    LEARN(R.string.bottom_bar_learn, R.drawable.ic_learn),
    TROPHIES(R.string.bottom_bar_trophies, R.drawable.ic_trophies),
    PROFILE(R.string.bottom_bar_profile, R.drawable.ic_profile)
}

@Composable
fun CodeNoxBottomBar(
    modifier: Modifier = Modifier,
    selectedTab: BottomBarTab = BottomBarTab.HOME,
    onTabSelected: (BottomBarTab) -> Unit = {}
) {
    val containerColor = CodeNoxTheme.colors.surface
    val selectedColor = CodeNoxTheme.colors.primary
    val unselectedColor = CodeNoxTheme.colors.textSecondary

    Box(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(84.dp)
            .clip(RoundedCornerShape(42.dp))
            .background(containerColor)
    ) {
        NavigationBar(
            containerColor = Color.Transparent,
            tonalElevation = 0.dp,
            windowInsets = WindowInsets(0, 0, 0, 0),
            modifier = Modifier.fillMaxHeight()
        ) {
            BottomBarTab.entries.forEach { tab ->
                val isSelected = tab == selectedTab
                NavigationBarItem(
                    selected = isSelected,
                    onClick = { onTabSelected(tab) },
                    icon = {
                        Icon(
                            painter = painterResource(id = tab.icon),
                            contentDescription = stringResource(tab.titleRes),
                            modifier = Modifier.size(26.dp)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(tab.titleRes),
                            style = CodeNoxTextStyles.DMSans12Medium
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = selectedColor,
                        selectedTextColor = selectedColor,
                        indicatorColor = selectedColor.copy(alpha = 0.12f),
                        unselectedIconColor = unselectedColor,
                        unselectedTextColor = unselectedColor
                    )
                )
            }
        }
    }
}

@Composable
fun NavigationBottomBar(
    currentTab: BottomBarTab,
    modifier: Modifier = Modifier,
    onNavigateToHome: () -> Unit = {},
    onNavigateToLearn: () -> Unit = {},
    onNavigateToTrophies: () -> Unit = {},
    onNavigateToProfile: () -> Unit = {}
) {
    CodeNoxBottomBar(
        modifier = modifier,
        selectedTab = currentTab,
        onTabSelected = { tab ->
            when (tab) {
                BottomBarTab.HOME -> onNavigateToHome()
                BottomBarTab.LEARN -> onNavigateToLearn()
                BottomBarTab.TROPHIES -> onNavigateToTrophies()
                BottomBarTab.PROFILE -> onNavigateToProfile()
            }
        }
    )
}

@Preview
@Composable
private fun BottomBarPreview() {
    CodeNoxTheme {
        CodeNoxBottomBar(
            selectedTab = BottomBarTab.HOME,
            onTabSelected = {}
        )
    }
}

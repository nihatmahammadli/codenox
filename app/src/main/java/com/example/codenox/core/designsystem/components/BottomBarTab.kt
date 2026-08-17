package com.example.codenox.core.designsystem.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.codenox.R

enum class BottomBarTab(
    @StringRes val titleRes: Int,
    @DrawableRes val icon: Int
) {
    HOME(R.string.bottom_bar_home, R.drawable.ic_home),
    LEARN(R.string.bottom_bar_learn, R.drawable.ic_learn),
    TROPHIES(R.string.bottom_bar_trophies, R.drawable.ic_trophies),
    PROFILE(R.string.bottom_bar_profile, R.drawable.ic_profile)
}

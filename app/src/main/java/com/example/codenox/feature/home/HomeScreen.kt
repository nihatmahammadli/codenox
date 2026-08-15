package com.example.codenox.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.components.HorizontalCenteredColumn
import com.example.codenox.feature.home.components.HomeHeader
import com.example.codenox.feature.home.components.StreakCard

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            HomeHeader(
                userName = "Nihat Mahammadli",
                profileImage = com.example.codenox.R.drawable.ic_default_profile
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                StreakCard(modifier = Modifier.weight(1f))
                StreakCard(modifier = Modifier.weight(1f))
            }
        }
    }
}

package com.example.codenox.feature.main.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    defaultTitle: String = "Welcome",
    userName: String,
    profileImage: Int,
    onProfileClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = defaultTitle,
                color = CodeNoxTheme.colors.textSecondary,
                style = CodeNoxTheme.typography.dmSans14Regular
            )
            Spacer(modifier = Modifier.padding(top = 5.2.dp))
            Text(
                text = userName,
                color = CodeNoxTheme.colors.textPrimary,
                style = CodeNoxTheme.typography.jetBrainsMono24Bold
            )
        }
        Image(
            modifier = modifier
                .size(40.dp)
                .clip(CircleShape)
                .clickable(onClick = onProfileClick),
            painter = painterResource(id = profileImage),
            contentDescription = null
        )
    }

}

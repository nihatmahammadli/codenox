package com.example.codenox.feature.auth.presentation.splash.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.core.designsystem.components.CodeNoxLogo
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun SplashContent(
    alpha: Float,
    scale: Float,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .alpha(alpha)
            .scale(scale)
    ) {
        CodeNoxLogo(
            modifier = Modifier.size(160.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "CodeNox",
            style = CodeNoxTheme.typography.dmSans36Bold,
            color = Color.White,
            letterSpacing = 2.sp
        )
    }
}

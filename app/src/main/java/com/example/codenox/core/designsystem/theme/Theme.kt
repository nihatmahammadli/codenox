package com.example.codenox.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = CodeNoxGreen,
    secondary = CodeNoxGold,
    tertiary = CodeNoxDarkGreen,
    background = BackgroundPrimary,
    surface = BackgroundSecondary,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = TextPrimary,
    onSurface = TextPrimary
)

private val LightColorScheme = lightColorScheme(
    primary = CodeNoxGreen,
    secondary = CodeNoxGold,
    tertiary = CodeNoxDarkGreen,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

object CodeNoxTheme {
    val colors: CodeNoxColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCodeNoxColors.current

    val typography: androidx.compose.material3.Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    val shapes: androidx.compose.material3.Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes
    
    val gradients: CodeNoxGradients
        get() = CodeNoxGradients
}

@Composable
fun CodeNoxTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customColors = if (darkTheme) CodeNoxColors() else CodeNoxColors(
        primary = CodeNoxGreen,
        secondary = CodeNoxGold,
        tertiary = CodeNoxDarkGreen,
        background = Color.White,
        surface = Color.White,
        textPrimary = Color.Black,
        textSecondary = Color.Gray,
        border = Color.LightGray
    )

    CompositionLocalProvider(
        LocalCodeNoxColors provides customColors
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = CodeNoxShapes,
            content = content
        )
    }
}

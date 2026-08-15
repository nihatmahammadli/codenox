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

// If you want a dark-themed app by default, LightColorScheme should also use dark colors
private val LightColorScheme = lightColorScheme(
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

object CodeNoxTheme {
    val colors: CodeNoxColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCodeNoxColors.current

    val typography: CodeNoxTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCodeNoxTypography.current

    val shapes: CodeNoxShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalCodeNoxShapes.current
    
    val gradients: CodeNoxGradients
        get() = CodeNoxGradients
}

@Composable
fun CodeNoxTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
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

    // Always use CodeNoxColors() which defaults to Dark theme colors,
    // or customize it if you actually want a different light theme later.
    val customColors = CodeNoxColors()
    
    val customTypography = CodeNoxTypography()
    val customShapes = CodeNoxShapes()

    CompositionLocalProvider(
        LocalCodeNoxColors provides customColors,
        LocalCodeNoxTypography provides customTypography,
        LocalCodeNoxShapes provides customShapes
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = MaterialTypography,
            shapes = MaterialShapes,
            content = content
        )
    }
}

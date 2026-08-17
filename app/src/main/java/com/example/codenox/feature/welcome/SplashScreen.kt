package com.example.codenox.feature.welcome

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.components.CodeNoxLogo
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit
) {
    var startAnimation by remember { mutableStateOf(false) }
    
    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "alpha"
    )
    
    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0.8f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale"
    )

    LaunchedEffect(Unit) {
        startAnimation = true
        delay(2500) 
        onSplashFinished()
    }

    CodeNoxBackground {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .alpha(alpha)
                    .scale(scale)
            ) {
                // Logo with Glow
                Box(contentAlignment = Alignment.Center) {
                    // Outer glow
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .blur(30.dp)
                            .background(
                                color = CodeNoxTheme.colors.primary.copy(alpha = 0.2f),
                                shape = CircleShape
                            )
                    )
                    
                    CodeNoxLogo(
                        modifier = Modifier.size(80.dp),
                        color = CodeNoxTheme.colors.primary
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text(
                    text = "CodeNox",
                    style = CodeNoxTheme.typography.dmSans36Bold,
                    color = Color.White,
                    letterSpacing = 2.sp
                )
            }
        }
    }
}

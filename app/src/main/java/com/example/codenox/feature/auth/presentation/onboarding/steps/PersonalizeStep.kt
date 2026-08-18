package com.example.codenox.feature.auth.presentation.onboarding.steps

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.core.designsystem.components.CodeNoxTextField
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun PersonalizeStep(
    name: String,
    onNameChange: (String) -> Unit,
    nickname: String,
    onNicknameChange: (String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "PERSONALIZE",
            style = CodeNoxTheme.typography.dmSans12Bold,
            color = CodeNoxTheme.colors.primary,
            letterSpacing = 2.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Tell us about\nyourself",
            style = CodeNoxTheme.typography.dmSans36Bold,
            color = Color.White,
            lineHeight = 44.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "We'll use this to customize your learning journey and set up your public developer profile.",
            style = CodeNoxTheme.typography.dmSans14Regular,
            color = CodeNoxTheme.colors.textSecondary
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        CodeNoxTextField(
            value = name,
            onValueChange = onNameChange,
            label = "Your Name",
            placeholder = "Nihat Mahammadli"
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        CodeNoxTextField(
            value = nickname,
            onValueChange = onNicknameChange,
            label = "Mr.Robot",
            placeholder = "nihat"
        )

    }
}

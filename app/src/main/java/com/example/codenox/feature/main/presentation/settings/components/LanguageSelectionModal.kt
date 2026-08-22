package com.example.codenox.feature.main.presentation.settings.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxButton
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.settings.LanguageType

@Composable
fun LanguageSelectionModal(
    currentLanguage: LanguageType,
    onDismiss: () -> Unit,
    onLanguageApplied: (LanguageType) -> Unit
) {
    var selectedLanguage by remember { mutableStateOf(currentLanguage) }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF121614), RoundedCornerShape(24.dp))
                .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                .padding(24.dp)
        ) {
            Text(
                text = "App Language",
                style = CodeNoxTheme.typography.dmSans18Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                LanguageType.entries.forEach { language ->
                    LanguageOptionItem(
                        label = language.label,
                        isSelected = selectedLanguage == language,
                        onClick = { selectedLanguage = language }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Cancel",
                    style = CodeNoxTheme.typography.dmSans16Bold,
                    color = CodeNoxTheme.colors.textSecondary,
                    modifier = Modifier
                        .weight(1f)
                        .clickable(onClick = onDismiss)
                        .padding(vertical = 12.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                CodeNoxButton(
                    text = "Apply",
                    onClick = { onLanguageApplied(selectedLanguage) },
                    modifier = Modifier.weight(1f),
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.Black
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun LanguageOptionItem(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = if (isSelected) CodeNoxTheme.colors.primary.copy(alpha = 0.05f) else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .border(
                width = 1.dp,
                color = if (isSelected) CodeNoxTheme.colors.primary else Color.White.copy(alpha = 0.05f),
                shape = RoundedCornerShape(12.dp)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = CodeNoxTheme.typography.dmSans16Medium,
            color = if (isSelected) Color.White else CodeNoxTheme.colors.textSecondary
        )
        
        Box(
            modifier = Modifier
                .size(20.dp)
                .border(
                    width = 1.dp,
                    color = if (isSelected) CodeNoxTheme.colors.primary else CodeNoxTheme.colors.textSecondary,
                    shape = androidx.compose.foundation.shape.CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isSelected) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(CodeNoxTheme.colors.primary, androidx.compose.foundation.shape.CircleShape)
                )
            }
        }
    }
}

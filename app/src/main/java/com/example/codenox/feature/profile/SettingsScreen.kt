package com.example.codenox.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    CodeNoxBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            
            // Top Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(0xFF121614), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(12.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                
                Spacer(modifier = Modifier.width(16.dp))
                
                Text(
                    text = "Settings",
                    style = CodeNoxTheme.typography.dmSans24Bold,
                    color = Color.White
                )
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // ACCOUNT SECTION
            SettingsSectionTitle("ACCOUNT")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF121614), RoundedCornerShape(24.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                    .padding(vertical = 8.dp)
            ) {
                SettingsProfileItem(
                    name = "Nihat Mahammadli",
                    username = "@nihat",
                    imageRes = R.drawable.ic_default_profile
                )
                SettingsDivider()
                SettingsValueItem(
                    label = "Email",
                    value = "nihat@devpath.com"
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // PREFERENCES SECTION
            SettingsSectionTitle("PREFERENCES")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF121614), RoundedCornerShape(24.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                    .padding(vertical = 8.dp)
            ) {
                SettingsValueItem(label = "App Language", value = "English")
                SettingsDivider()
                SettingsValueItem(label = "Theme Mode", value = "Dark Theme")
                SettingsDivider()
                var notificationsEnabled by remember { mutableStateOf(true) }
                SettingsSwitchItem(
                    label = "Push Notifications",
                    checked = notificationsEnabled,
                    onCheckedChange = { notificationsEnabled = it }
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // LEARNING SECTION
            SettingsSectionTitle("LEARNING")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF121614), RoundedCornerShape(24.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                    .padding(vertical = 8.dp)
            ) {
                SettingsValueItem(label = "Daily Goal", value = "45 / 60m")
                SettingsDivider()
                var downloadWifi by remember { mutableStateOf(false) }
                SettingsSwitchItem(
                    label = "Download over Wi-Fi",
                    checked = downloadWifi,
                    onCheckedChange = { downloadWifi = it }
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // ABOUT SECTION
            SettingsSectionTitle("ABOUT")
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF121614), RoundedCornerShape(24.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                    .padding(vertical = 8.dp)
            ) {
                SettingsActionItem(label = "Rate CodeNox")
                SettingsDivider()
                SettingsActionItem(label = "Share App")
                SettingsDivider()
                SettingsActionItem(label = "Privacy Policy", showChevron = true)
                SettingsDivider()
                SettingsActionItem(label = "Terms of Service", showChevron = true)
            }
            
            Spacer(modifier = Modifier.height(48.dp))
            
            // Logout Button
            Button(
                onClick = onLogoutClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1A1212),
                    contentColor = Color(0xFFFF4B4B)
                ),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFFF4B4B).copy(alpha = 0.1f))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Log Out",
                        style = CodeNoxTheme.typography.dmSans16Bold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_logout),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFFFF4B4B)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "CodeNox v1.0.0 (Compose stable)",
                style = CodeNoxTheme.typography.dmSans12Regular,
                color = CodeNoxTheme.colors.textSecondary.copy(alpha = 0.5f),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SettingsSectionTitle(title: String) {
    Text(
        text = title,
        style = CodeNoxTheme.typography.dmSans12Bold,
        color = CodeNoxTheme.colors.textSecondary,
        modifier = Modifier.padding(start = 4.dp, bottom = 12.dp),
        letterSpacing = 1.sp
    )
}

@Composable
private fun SettingsDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(1.dp)
            .background(Color.White.copy(alpha = 0.03f))
    )
}

@Composable
private fun SettingsProfileItem(
    name: String,
    username: String,
    imageRes: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = name,
            style = CodeNoxTheme.typography.dmSans16Bold,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = username,
            style = CodeNoxTheme.typography.dmSans14Regular,
            color = CodeNoxTheme.colors.textSecondary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_chevron_right),
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = CodeNoxTheme.colors.textSecondary
        )
    }
}

@Composable
private fun SettingsValueItem(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = CodeNoxTheme.typography.dmSans16Medium,
            color = Color.White
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = value,
                style = CodeNoxTheme.typography.dmSans14Regular,
                color = CodeNoxTheme.colors.textSecondary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_right),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = CodeNoxTheme.colors.textSecondary
            )
        }
    }
}

@Composable
private fun SettingsActionItem(
    label: String,
    showChevron: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = CodeNoxTheme.typography.dmSans16Medium,
            color = Color.White
        )
        if (showChevron) {
            Icon(
                painter = painterResource(id = R.drawable.ic_chevron_right),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = CodeNoxTheme.colors.textSecondary
            )
        }
    }
}

@Composable
private fun SettingsSwitchItem(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            style = CodeNoxTheme.typography.dmSans16Medium,
            color = Color.White
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Black,
                checkedTrackColor = CodeNoxTheme.colors.primary,
                uncheckedThumbColor = CodeNoxTheme.colors.textSecondary,
                uncheckedTrackColor = Color(0xFF1A1F1C),
                uncheckedBorderColor = Color.Transparent
            )
        )
    }
}

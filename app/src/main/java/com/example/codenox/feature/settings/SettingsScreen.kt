package com.example.codenox.feature.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.settings.components.SettingsActionItem
import com.example.codenox.feature.settings.components.SettingsDivider
import com.example.codenox.feature.settings.components.SettingsProfileItem
import com.example.codenox.feature.settings.components.SettingsSectionTitle
import com.example.codenox.feature.settings.components.SettingsSwitchItem
import com.example.codenox.feature.settings.components.SettingsValueItem

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
                border = BorderStroke(1.dp, Color(0xFFFF4B4B).copy(alpha = 0.1f))
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
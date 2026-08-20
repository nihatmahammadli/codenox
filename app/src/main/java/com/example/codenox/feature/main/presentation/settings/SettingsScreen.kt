package com.example.codenox.feature.main.presentation.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.settings.components.*

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onEditNameClick: () -> Unit,
    onEditEmailClick: () -> Unit,
    onDailyGoalClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    BaseScreen<SettingsUiState, SettingsViewModel> { uiState, viewModel ->
        CodeNoxBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
                    .statusBarsPadding()
                    .padding(top = 16.dp, bottom = 32.dp)
            ) {
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
                        onClick = onEditNameClick,
                        name = uiState.profile?.fullName ?: "Full name",
                        username = uiState.profile?.nickname ?: "nickname",
                        imageRes = R.drawable.ic_default_profile
                    )
                    SettingsDivider()
                    SettingsValueItem(
                        onClick = onEditEmailClick,
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
                    SettingsValueItem(
                        label = "App Language",
                        value = uiState.selectedLanguage.label,
                        onClick = viewModel::showLanguageModal
                    )
                    SettingsDivider()
                    SettingsValueItem(
                        label = "Theme Mode",
                        value = uiState.selectedTheme.label,
                        onClick = viewModel::showThemeModal
                    )
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
                    SettingsValueItem(
                        label = "Daily Goal",
                        value = "45 / 60m",
                        onClick = onDailyGoalClick
                    )
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
            }
        }

        // Modals
        if (uiState.isThemeModalVisible) {
            ThemeSelectionModal(
                currentTheme = uiState.selectedTheme,
                onDismiss = viewModel::hideThemeModal,
                onThemeApplied = viewModel::onThemeSelected
            )
        }

        if (uiState.isLanguageModalVisible) {
            LanguageSelectionModal(
                currentLanguage = uiState.selectedLanguage,
                onDismiss = viewModel::hideLanguageModal,
                onLanguageApplied = viewModel::onLanguageSelected
            )
        }
    }
}

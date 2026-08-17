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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun ProfileScreen(
    onSettingsClick: () -> Unit = {},
    onLearnClick: () -> Unit = {}
) {
    BaseScreen<ProfileUiState, ProfileViewModel> { uiState, viewModel ->
        CodeNoxBackground {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                ProfileHeader(onSettingsClick = onSettingsClick)
                Spacer(modifier = Modifier.height(24.dp))
                ProfileUserCard(
                    fullName = uiState.profile?.fullName,
                    nickname = uiState.profile?.nickname
                )
                Spacer(modifier = Modifier.height(24.dp))
                StatsRow()
                Spacer(modifier = Modifier.height(32.dp))
                LearningProgressSection(onClick = onLearnClick)
                Spacer(modifier = Modifier.height(32.dp))
                RecentActivitySection()
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
private fun ProfileHeader(onSettingsClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "My Profile",
            style = CodeNoxTheme.typography.dmSans24Bold,
            color = Color.White
        )
        
        IconButton(
            onClick = onSettingsClick,
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFF121614), RoundedCornerShape(12.dp))
                .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(12.dp))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "Settings",
                tint = CodeNoxTheme.colors.textSecondary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun ProfileUserCard(
    nickname: String?,
    fullName: String?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF121614), RoundedCornerShape(24.dp))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .border(2.dp, CodeNoxTheme.colors.primary, CircleShape)
                    .padding(4.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_default_profile),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column {
                Text(
                    text = fullName ?: "New Developer",
                    style = CodeNoxTheme.typography.dmSans20Bold,
                    color = Color.White
                )
                Text(
                    text = nickname ?: "@nickname",
                    style = CodeNoxTheme.typography.dmSans14Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color.White.copy(alpha = 0.05f)))
        
        Spacer(modifier = Modifier.height(20.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Text(
                    text = "XP LEVEL BADGE",
                    style = CodeNoxTheme.typography.dmSans10Bold,
                    color = CodeNoxTheme.colors.textSecondary,
                    letterSpacing = 1.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Level 0 Beginner",
                    style = CodeNoxTheme.typography.dmSans16Bold,
                    color = Color.White
                )
            }
            
            Text(
                text = "0 / 100 XP",
                style = CodeNoxTheme.typography.dmSans12Bold,
                color = CodeNoxTheme.colors.primary
            )
        }
        
        Spacer(modifier = Modifier.height(12.dp))
        
        LinearProgressIndicator(
            progress = { 0f },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(CircleShape),
            color = CodeNoxTheme.colors.primary,
            trackColor = Color(0xFF1A1F1C),
            strokeCap = StrokeCap.Round
        )
    }
}

@Composable
private fun StatsRow() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        StatCard(
            value = "0",
            label = "Courses Done",
            modifier = Modifier.weight(1f)
        )
        StatCard(
            value = "0",
            label = "Achievements",
            modifier = Modifier.weight(1f)
        )
        StatCard(
            value = "0",
            label = "Day Streak",
            valueColor = CodeNoxTheme.colors.primary,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun StatCard(
    value: String,
    label: String,
    modifier: Modifier = Modifier,
    valueColor: Color = Color.White
) {
    Column(
        modifier = modifier
            .height(100.dp)
            .background(Color(0xFF121614), RoundedCornerShape(20.dp))
            .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(20.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = value,
            style = CodeNoxTheme.typography.dmSans24Bold,
            color = valueColor
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            style = CodeNoxTheme.typography.dmSans12Regular,
            color = CodeNoxTheme.colors.textSecondary
        )
    }
}

@Composable
private fun LearningProgressSection(onClick: () -> Unit) {
    Column {
        Text(
            text = "LEARNING PROGRESS",
            style = CodeNoxTheme.typography.dmSans12Bold,
            color = CodeNoxTheme.colors.textSecondary,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFF121614))
                .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                .clickable(onClick = onClick)
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "MODULE 1 • KOTLIN BASICS",
                        style = CodeNoxTheme.typography.dmSans12Bold,
                        color = CodeNoxTheme.colors.primary
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Getting Started",
                        style = CodeNoxTheme.typography.dmSans18Bold,
                        color = Color.White
                    )
                }
                
                Box(
                    modifier = Modifier
                        .background(CodeNoxTheme.colors.primary.copy(alpha = 0.1f), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "0%",
                        style = CodeNoxTheme.typography.dmSans12Bold,
                        color = CodeNoxTheme.colors.primary
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(20.dp))
            
            LinearProgressIndicator(
                progress = { 0f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(CircleShape),
                color = CodeNoxTheme.colors.primary,
                trackColor = Color(0xFF1A1F1C),
                strokeCap = StrokeCap.Round
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "0 of 10 lessons completed in this path.",
                style = CodeNoxTheme.typography.dmSans12Regular,
                color = CodeNoxTheme.colors.textSecondary
            )
        }
    }
}

@Composable
private fun RecentActivitySection() {
    Column {
        Text(
            text = "RECENT ACTIVITY",
            style = CodeNoxTheme.typography.dmSans12Bold,
            color = CodeNoxTheme.colors.textSecondary,
            letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No recent activity yet.",
                style = CodeNoxTheme.typography.dmSans14Regular,
                color = CodeNoxTheme.colors.textSecondary.copy(alpha = 0.6f)
            )
        }
    }
}

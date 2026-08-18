package com.example.codenox.feature.main.presentation.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

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
            drawStopIndicator = {}
        )
    }
}

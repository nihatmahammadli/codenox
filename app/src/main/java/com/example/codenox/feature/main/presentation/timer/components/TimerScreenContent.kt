package com.example.codenox.feature.main.presentation.timer.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.timer.TimerScreenUiState

@Composable
fun TimerScreenContent(
    uiState: TimerScreenUiState,
    onAction: (TimerAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { onAction(TimerAction.OnBackClick) },
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

                Text(
                    text = "Pomodoro",
                    style = CodeNoxTheme.typography.dmSans18Bold,
                    color = Color.White
                )

                IconButton(
                    onClick = { onAction(TimerAction.OnSettingsClick) },
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color(0xFF121614), RoundedCornerShape(12.dp))
                        .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(12.dp))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = "Settings",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            TimerRing(
                progress = uiState.progress,
                remainingTime = uiState.remainingTime,
                label = uiState.timerLabel
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                IconButton(
                    onClick = { onAction(TimerAction.OnResetClick) },
                    modifier = Modifier.size(44.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_restart_timer),
                        contentDescription = "Reset",
                        tint = Color.Unspecified,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                IconButton(
                    onClick = { onAction(TimerAction.OnToggleClick) },
                    modifier = Modifier.size(72.dp)
                ) {
                    Icon(
                        painter = painterResource(id = if (uiState.isRunning) R.drawable.ic_arrow_back else R.drawable.ic_start_timer),
                        contentDescription = if (uiState.isRunning) "Pause" else "Play",
                        tint = Color.Unspecified,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                IconButton(
                    onClick = { onAction(TimerAction.OnSkipClick) },
                    modifier = Modifier.size(44.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_skip_timer),
                        contentDescription = "Skip",
                        tint = Color.Unspecified,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    repeat(uiState.totalSessions) { index ->
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .background(
                                    if (index < uiState.currentSession) CodeNoxTheme.colors.primary
                                    else Color.White.copy(alpha = 0.1f),
                                    CircleShape
                                )
                        )
                    }
                }
                Text(
                    text = "Session ${uiState.currentSession} of ${uiState.totalSessions}",
                    style = CodeNoxTheme.typography.dmSans12Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CodeNoxTheme.colors.surface, RoundedCornerShape(24.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_study),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "CURRENTLY STUDYING",
                        style = CodeNoxTheme.typography.jetBrainsMono12Bold,
                        color = CodeNoxTheme.colors.primary
                    )
                }
                Text(
                    text = uiState.currentlyStudying,
                    style = CodeNoxTheme.typography.jetBrainsMono18Bold,
                    color = Color.White
                )
                LinearProgressIndicator(
                    progress = { 0.35f },
                    modifier = Modifier
                        .width(120.dp)
                        .height(4.dp)
                        .clip(CircleShape),
                    color = CodeNoxTheme.colors.primary,
                    trackColor = Color.White.copy(alpha = 0.1f),
                    strokeCap = StrokeCap.Butt,
                    drawStopIndicator = {},
                    gapSize = 0.dp
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "CONFIGURATION",
                    style = CodeNoxTheme.typography.jetBrainsMono12Bold,
                    color = CodeNoxTheme.colors.textSecondary
                )
                TimerConfigRow(
                    label = "Focus Duration",
                    value = uiState.focusDuration,
                    onDecrease = { onAction(TimerAction.OnFocusDurationChange(-1)) },
                    onIncrease = { onAction(TimerAction.OnFocusDurationChange(1)) }
                )
                TimerConfigRow(
                    label = "Short Break",
                    value = uiState.shortBreakDuration,
                    onDecrease = { onAction(TimerAction.OnShortBreakChange(-1)) },
                    onIncrease = { onAction(TimerAction.OnShortBreakChange(1)) }
                )
                TimerConfigRow(
                    label = "Long Break",
                    value = uiState.longBreakDuration,
                    onDecrease = { onAction(TimerAction.OnLongBreakChange(-1)) },
                    onIncrease = { onAction(TimerAction.OnLongBreakChange(1)) }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CodeNoxTheme.colors.surface, RoundedCornerShape(24.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(24.dp))
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(CodeNoxTheme.colors.primary.copy(alpha = 0.1f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_stats),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "TODAY'S EFFORT",
                        style = CodeNoxTheme.typography.jetBrainsMono12Bold,
                        color = CodeNoxTheme.colors.textSecondary
                    )
                    Text(
                        text = "${uiState.todaySessions} sessions · ${uiState.todayFocusedTime} focused",
                        style = CodeNoxTheme.typography.dmSans14Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

package com.example.codenox.feature.main.presentation.timer

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.base.BaseScreen
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.timer.components.TimerConfigRow
import com.example.codenox.feature.main.presentation.timer.components.TimerRing

@Composable
fun TimerScreen(
    onBackClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    val scrollState = rememberScrollState()

    BaseScreen<TimerScreenUiState, TimerScreenViewModel> { uiState, viewModel ->
        CodeNoxBackground {
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
                // Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color(0xFF121614), RoundedCornerShape(12.dp))
                            .border(
                                1.dp,
                                Color.White.copy(alpha = 0.05f),
                                RoundedCornerShape(12.dp)
                            )
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
                        onClick = onSettingsClick,
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color(0xFF121614), RoundedCornerShape(12.dp))
                            .border(
                                1.dp,
                                Color.White.copy(alpha = 0.05f),
                                RoundedCornerShape(12.dp)
                            )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings),
                            contentDescription = "Settings",
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

                // Timer Ring
                TimerRing(
                    progress = uiState.progress,
                    remainingTime = uiState.remainingTime,
                    label = uiState.timerLabel
                )

                // Controls
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    IconButton(
                        onClick = viewModel::resetTimer,
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
                        onClick = viewModel::toggleTimer,
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
                        onClick = viewModel::skipSession,
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

                // Session Indicator
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

                // Currently Studying
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

                // Configuration
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
                        onDecrease = { viewModel.updateFocusDuration(-1) },
                        onIncrease = { viewModel.updateFocusDuration(1) }
                    )
                    TimerConfigRow(
                        label = "Short Break",
                        value = uiState.shortBreakDuration,
                        onDecrease = { viewModel.updateShortBreak(-1) },
                        onIncrease = { viewModel.updateShortBreak(1) }
                    )
                    TimerConfigRow(
                        label = "Long Break",
                        value = uiState.longBreakDuration,
                        onDecrease = { viewModel.updateLongBreak(-1) },
                        onIncrease = { viewModel.updateLongBreak(1) }
                    )
                }

                // Effort Card
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
                            .background(
                                CodeNoxTheme.colors.primary.copy(alpha = 0.1f),
                                CircleShape
                            ),
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
}

@Preview
@Composable
fun TimerScreenPreview() {
    CodeNoxTheme {
        TimerScreen(onBackClick = {}, onSettingsClick = {})
    }
}

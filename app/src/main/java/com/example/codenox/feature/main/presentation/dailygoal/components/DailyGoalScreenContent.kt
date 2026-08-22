package com.example.codenox.feature.main.presentation.dailygoal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxBackground
import com.example.codenox.core.designsystem.components.CodeNoxButton
import com.example.codenox.core.designsystem.components.WheelPicker
import com.example.codenox.core.designsystem.theme.CodeNoxTheme
import com.example.codenox.feature.main.presentation.dailygoal.DailyGoalUiState

@Composable
fun DailyGoalScreenContent(
    uiState: DailyGoalUiState,
    onAction: (DailyGoalAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val hours = (0..23).map { it.toString().padStart(2, '0') }
    val minutes = (0..59 step 5).map { it.toString().padStart(2, '0') }

    CodeNoxBackground(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .statusBarsPadding()
                .padding(top = 16.dp, bottom = 32.dp)
        ) {
            DailyGoalHeader { onAction(DailyGoalAction.OnBackClick) }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "SET TIME",
                style = CodeNoxTheme.typography.dmSans12Bold,
                color = CodeNoxTheme.colors.textSecondary,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Select the duration you want to study every day.",
                style = CodeNoxTheme.typography.dmSans14Regular,
                color = CodeNoxTheme.colors.textSecondary
            )

            Spacer(modifier = Modifier.height(48.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "HOUR",
                    style = CodeNoxTheme.typography.dmSans10Bold,
                    color = CodeNoxTheme.colors.textSecondary,
                    letterSpacing = 2.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "MINUTE",
                    style = CodeNoxTheme.typography.dmSans10Bold,
                    color = CodeNoxTheme.colors.textSecondary,
                    letterSpacing = 2.sp,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(contentAlignment = Alignment.Center) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .border(
                            width = 1.dp,
                            color = CodeNoxTheme.colors.primary.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(0.dp)
                        )
                        .background(CodeNoxTheme.colors.primary.copy(alpha = 0.05f))
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    WheelPicker(
                        items = hours,
                        initialIndex = uiState.selectedHour,
                        onItemSelected = { onAction(DailyGoalAction.OnHourChange(it)) },
                        modifier = Modifier.weight(1f)
                    )
                    WheelPicker(
                        items = minutes,
                        initialIndex = minutes.indexOf(uiState.selectedMinute.toString().padStart(2, '0')).coerceAtLeast(0),
                        onItemSelected = { onAction(DailyGoalAction.OnMinuteChange(minutes[it].toInt())) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(48.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF121614), RoundedCornerShape(16.dp))
                    .border(1.dp, Color.White.copy(alpha = 0.05f), RoundedCornerShape(16.dp))
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(CodeNoxTheme.colors.primary.copy(alpha = 0.1f), RoundedCornerShape(12.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_advice),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = CodeNoxTheme.colors.primary
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "ADVICE",
                        style = CodeNoxTheme.typography.dmSans10Bold,
                        color = CodeNoxTheme.colors.textSecondary,
                        letterSpacing = 1.sp
                    )
                    Text(
                        text = "Studying 45 minutes daily ensures regular learning.",
                        style = CodeNoxTheme.typography.dmSans14Bold,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            CodeNoxButton(
                text = "Save",
                onClick = { onAction(DailyGoalAction.OnSaveClick) },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                }
            )
        }
    }
}

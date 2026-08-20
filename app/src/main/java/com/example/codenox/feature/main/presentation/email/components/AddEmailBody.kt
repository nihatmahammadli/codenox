package com.example.codenox.feature.main.presentation.email.components

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.codenox.R
import com.example.codenox.core.designsystem.components.CodeNoxButton
import com.example.codenox.core.designsystem.components.CodeNoxTextField
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun AddEmailBody(
    email: String,
    onEmailChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    isButtonEnabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        CodeNoxTextField(
            value = email,
            onValueChange = onEmailChange,
            label = "Email Address",
            placeholder = "nihat@devpath.com"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "VERIFICATION",
            style = CodeNoxTheme.typography.dmSans12Bold,
            color = CodeNoxTheme.colors.textSecondary,
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF121614),
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.05f),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = CodeNoxTheme.colors.primary.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_code_nox_logo),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = CodeNoxTheme.colors.primary
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Text(
                text = "A verification link will be sent to your new email address.",
                style = CodeNoxTheme.typography.dmSans14Regular,
                color = CodeNoxTheme.colors.textSecondary,
                lineHeight = 20.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        CodeNoxButton(
            text = "Save Changes",
            onClick = onSaveClick,
            enabled = isButtonEnabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
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

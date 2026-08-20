package com.example.codenox.feature.main.presentation.editname.components

import androidx.compose.foundation.layout.*
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
fun EditNameBody(
    fullName: String,
    onFullNameChange: (String) -> Unit,
    nickname: String,
    onNicknameChange: (String) -> Unit,
    onSaveClick: () -> Unit,
    isButtonEnabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Full Name Field
        CodeNoxTextField(
            value = fullName,
            onValueChange = onFullNameChange,
            label = "Full Name",
            placeholder = "Nihat Mahammadli"
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Nickname Field
        CodeNoxTextField(
            value = nickname,
            onValueChange = onNicknameChange,
            label = "Nickname",
            placeholder = "nihat"
        )

        Spacer(modifier = Modifier.weight(1f))

        // Save Button
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

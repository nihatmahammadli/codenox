package com.example.codenox.core.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.codenox.R

@Composable
fun CodeNoxLogo(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.ic_code_nox_logo),
        contentDescription = "CodeNox Logo",
        modifier = modifier
    )
}

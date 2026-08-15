package com.example.codenox.core.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun CodeNoxBackground(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit
) {
    AppScaffold(
        modifier = modifier.fillMaxSize(),
        topBar = topBar,
        contentWindowInsets = WindowInsets.systemBars
    ) { scaffoldPadding ->

        HorizontalCenteredColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(CodeNoxTheme.colors.background)
                .padding(scaffoldPadding),
            verticalArrangement = Arrangement.Top
        ) {
            content()
        }
    }
}
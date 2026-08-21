package com.example.codenox.feature.main.presentation.learn.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.codenox.R
import com.example.codenox.core.designsystem.theme.CodeNoxTheme

@Composable
fun LearnSearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    categories: List<String>,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Search TextField
        TextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(32.dp)),
            placeholder = {
                Text(
                    text = "Search lessons, topics, code...",
                    style = CodeNoxTheme.typography.dmSans14Regular,
                    color = CodeNoxTheme.colors.textSecondary
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = CodeNoxTheme.colors.textSecondary,
                    modifier = Modifier.size(24.dp)
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = CodeNoxTheme.colors.surface,
                unfocusedContainerColor = CodeNoxTheme.colors.surface,
                disabledContainerColor = CodeNoxTheme.colors.surface,
                cursorColor = CodeNoxTheme.colors.primary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            textStyle = CodeNoxTheme.typography.dmSans14Regular.copy(color = CodeNoxTheme.colors.textPrimary)
        )

        // Categories List
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            items(categories) { category ->
                val isSelected = category == selectedCategory
                CategoryChip(
                    text = category,
                    isSelected = isSelected,
                    onClick = { onCategorySelected(category) }
                )
            }
        }
    }
}

@Composable
private fun CategoryChip(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (isSelected) CodeNoxTheme.colors.primary else CodeNoxTheme.colors.surface
            )
            .clickable(onClick = onClick)
            .then(
                if (!isSelected) {
                    Modifier.border(1.dp, CodeNoxTheme.colors.borderSecondary, RoundedCornerShape(20.dp))
                } else Modifier
            )
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = if (isSelected) CodeNoxTheme.typography.dmSans12Bold else CodeNoxTheme.typography.dmSans12Medium,
            color = if (isSelected) Color.Black else CodeNoxTheme.colors.textSecondary
        )
    }
}

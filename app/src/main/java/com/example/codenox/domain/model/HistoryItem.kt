package com.example.codenox.domain.model

data class HistoryItem(
    val id: String,
    val title: String,
    val type: String, // e.g., "Cheatsheet", "Article"
    val duration: String? = null, // e.g., "5 min"
    val iconRes: Int? = null
)

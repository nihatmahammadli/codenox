package com.example.codenox.domain.model

data class HistoryItem(
    val id: String,
    val title: String,
    val type: String,
    val duration: String? = null,
    val iconRes: Int? = null
)

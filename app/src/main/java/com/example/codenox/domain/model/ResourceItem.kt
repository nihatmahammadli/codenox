package com.example.codenox.domain.model

data class ResourceItem(
    val title: String,
    val url: String,
    val description: String,
    val videoTime: String,
    val platform: ResourcePlatforms
)

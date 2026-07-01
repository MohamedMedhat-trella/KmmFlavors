package com.hacker.core.config

data class AppConfig(
    val brand: Brand,
    val environment: Environment,
    val apiBaseUrl: String,
    val appDisplayName: String,
    val featureFlags: FeatureFlags,
)

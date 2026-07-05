package com.hacker.core.config

data class AppConfig(
    val brand: Brand,
    val environment: Environment,
    val appDisplayName: String,
    val featureFlags: FeatureFlags,
    val baseUrls: BaseUrls
)

data class BaseUrls(
    val accounts: String,
    val financial: String,
)
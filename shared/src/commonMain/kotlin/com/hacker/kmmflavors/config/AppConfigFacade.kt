package com.hacker.kmmflavors.config

import com.hacker.core.config.AppConfig
import com.hacker.core.config.Brand
import com.hacker.core.config.Environment
import com.hacker.core.config.FeatureFlags

/**
 * The one thing the UI layer is allowed to know about configuration: a flat, read-only
 * view of the currently resolved AppConfig. UI code depends on this, never on AppConfig
 * or BuildSelector directly.
 */
interface AppConfigFacade {
    val brand: Brand
    val environment: Environment
    val appDisplayName: String
    val apiBaseUrl: String
    val featureFlags: FeatureFlags
}

class DefaultAppConfigFacade(
    private val appConfig: AppConfig,
) : AppConfigFacade {
    override val brand: Brand get() = appConfig.brand
    override val environment: Environment get() = appConfig.environment
    override val appDisplayName: String get() = appConfig.appDisplayName
    override val apiBaseUrl: String get() = appConfig.apiBaseUrl
    override val featureFlags: FeatureFlags get() = appConfig.featureFlags
}

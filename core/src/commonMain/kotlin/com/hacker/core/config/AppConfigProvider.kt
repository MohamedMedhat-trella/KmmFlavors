package com.hacker.core.config

interface AppConfigProvider {
    fun get(): AppConfig
}

/**
 * Resolves [AppConfig] from a pure, exhaustive lookup table. Every brand/environment
 * combination is listed explicitly (no fallback branch) so adding a new brand or
 * environment forces a compile error here until its config is supplied.
 */
class DefaultAppConfigProvider(
    private val selector: BuildSelector,
) : AppConfigProvider {

    override fun get(): AppConfig = when (selector.brand) {
        Brand.TRELLA -> when (selector.environment) {
            Environment.STAGING -> AppConfig(
                brand = Brand.TRELLA,
                environment = Environment.STAGING,
                apiBaseUrl = "https://api.staging.trella.app",
                appDisplayName = "Trella (Staging)",
                featureFlags = FeatureFlags(
                    isPromotionsBannerEnabled = false,
                    isDebugMenuEnabled = true,
                ),
            )

            Environment.PRODUCTION -> AppConfig(
                brand = Brand.TRELLA,
                environment = Environment.PRODUCTION,
                apiBaseUrl = "https://api.trella.app",
                appDisplayName = "Trella",
                featureFlags = FeatureFlags(
                    isPromotionsBannerEnabled = false,
                    isDebugMenuEnabled = false,
                ),
            )
        }

        Brand.OSTOULY -> when (selector.environment) {
            Environment.STAGING -> AppConfig(
                brand = Brand.OSTOULY,
                environment = Environment.STAGING,
                apiBaseUrl = "https://api.staging.ostouly.com",
                appDisplayName = "Ostouly (Staging)",
                featureFlags = FeatureFlags(
                    isPromotionsBannerEnabled = true,
                    isDebugMenuEnabled = true,
                ),
            )

            Environment.PRODUCTION -> AppConfig(
                brand = Brand.OSTOULY,
                environment = Environment.PRODUCTION,
                apiBaseUrl = "https://api.ostouly.com",
                appDisplayName = "Ostouly",
                featureFlags = FeatureFlags(
                    isPromotionsBannerEnabled = true,
                    isDebugMenuEnabled = false,
                ),
            )
        }
    }
}

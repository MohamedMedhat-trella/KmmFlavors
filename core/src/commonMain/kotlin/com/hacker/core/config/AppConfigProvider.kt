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
                appDisplayName = "Trella (Staging)",
                featureFlags = FeatureFlags(
                    isPromotionsBannerEnabled = false,
                    isDebugMenuEnabled = true,
                ),
                BaseUrls(
                    accounts = "https://accounts.staging.trella.app",
                    financial = "https://financial.staging.trella.app",
                )
            )

            Environment.PRODUCTION -> AppConfig(
                brand = Brand.TRELLA,
                environment = Environment.PRODUCTION,
                appDisplayName = "Trella",
                featureFlags = FeatureFlags(
                    isPromotionsBannerEnabled = false,
                    isDebugMenuEnabled = false,
                ),
                BaseUrls(
                    accounts = "https://accounts.trella.app",
                    financial = "https://financial.trella.app",
                )
            )
        }

        Brand.OSTOULY -> when (selector.environment) {
            Environment.STAGING -> AppConfig(
                brand = Brand.OSTOULY,
                environment = Environment.STAGING,
                appDisplayName = "Ostouly (Staging)",
                featureFlags = FeatureFlags(
                    isPromotionsBannerEnabled = true,
                    isDebugMenuEnabled = true,
                ),
                BaseUrls(
                    accounts = "https://accounts.staging.ostouly.com",
                    financial = "https://financial.staging.ostouly.com",
                )
            )

            Environment.PRODUCTION -> AppConfig(
                brand = Brand.OSTOULY,
                environment = Environment.PRODUCTION,
                appDisplayName = "Ostouly",
                featureFlags = FeatureFlags(
                    isPromotionsBannerEnabled = true,
                    isDebugMenuEnabled = false,
                ),
                BaseUrls(
                    accounts = "https://accounts.ostouly.com",
                    financial = "https://financial.ostouly.com",
                )
            )
        }
    }
}

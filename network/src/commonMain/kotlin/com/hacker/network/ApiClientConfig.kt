package com.hacker.network

import com.hacker.core.config.BaseUrls

/**
 * Everything the network layer needs from [com.hacker.core.config.AppConfig], narrowed to
 * this module's concerns. network never reads AppConfig directly so it stays decoupled from
 * config fields it doesn't use (brand, display name, feature flags).
 */
data class ApiClientConfig(
    val baseUrls: BaseUrls
)

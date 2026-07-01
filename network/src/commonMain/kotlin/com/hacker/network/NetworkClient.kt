package com.hacker.network

/**
 * Stand-in for a real HTTP client (Ktor, etc.). It proves that [ApiClientConfig] - and
 * therefore the resolved AppConfig.apiBaseUrl - flows all the way down to the lowest
 * layer that needs it, via constructor injection rather than a hardcoded constant.
 */
class NetworkClient(
    private val config: ApiClientConfig,
) {
    fun resolveUrl(path: String): String = config.baseUrl.trimEnd('/') + "/" + path.trimStart('/')
}

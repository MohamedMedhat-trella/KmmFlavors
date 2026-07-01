package com.hacker.core.config

/**
 * The single seam between "how brand/environment are chosen" and "what config that implies".
 * Every source of truth for flavor selection - Gradle product flavors today, a runtime toggle,
 * a remote config value tomorrow - implements this and nothing downstream needs to change.
 */
interface BuildSelector {
    val brand: Brand
    val environment: Environment
}

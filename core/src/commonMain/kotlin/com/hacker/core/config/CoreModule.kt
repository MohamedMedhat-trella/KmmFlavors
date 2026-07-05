package com.hacker.core.config

import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Provides the [BuildSelector] passed in from the app entry point, and resolves the
 * singleton [AppConfig] from it once. Everything downstream injects [AppConfig] and
 * never touches [BuildSelector] again.
 */
fun coreModule(selector: BuildSelector): Module = module {
    single<BuildSelector> { selector }
    single<AppConfigProvider> { DefaultAppConfigProvider(get()) }
    single<AppConfig> { get<AppConfigProvider>().get() }
}

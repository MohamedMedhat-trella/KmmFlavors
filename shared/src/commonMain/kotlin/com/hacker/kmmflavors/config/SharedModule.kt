package com.hacker.kmmflavors.config

import com.hacker.core.config.AppConfig
import com.hacker.core.config.BuildSelector
import com.hacker.core.config.coreModule
import com.hacker.network.networkModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun sharedModule(): Module = module {
    single<AppConfigFacade> { DefaultAppConfigFacade(get<AppConfig>()) }
}

/**
 * Single entry point for wiring up DI, called once from platform-entry code (the Android
 * Application class today; an iOS equivalent could call this the same way tomorrow). Takes
 * a [BuildSelector] so this module - and everything below it - never depends on how brand/
 * environment were determined.
 */
fun initKoin(selector: BuildSelector) {
    startKoin {
        modules(coreModule(selector), networkModule(), sharedModule())
    }
}

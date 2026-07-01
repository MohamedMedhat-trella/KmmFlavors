package com.hacker.network

import com.hacker.core.config.AppConfig
import org.koin.core.module.Module
import org.koin.dsl.module

fun networkModule(): Module = module {
    single { ApiClientConfig(baseUrl = get<AppConfig>().apiBaseUrl) }
    single { NetworkClient(get()) }
}

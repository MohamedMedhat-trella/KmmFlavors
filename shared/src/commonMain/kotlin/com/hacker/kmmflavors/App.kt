package com.hacker.kmmflavors

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hacker.kmmflavors.config.AppConfigFacade
import com.hacker.kmmflavors.config.ConfigSummaryCard
import org.koin.compose.koinInject

/**
 * Cross-platform entry point: renders the config resolved by whichever [com.hacker.core.config.BuildSelector]
 * was passed to `initKoin` on this platform (androidApp passes `AndroidFlavorSelector`; an iOS
 * entry point would pass its own). Not annotated with `@Preview`: rendering it requires a live
 * Koin instance, which `initKoin` only provides once a real app has started - preview
 * rendering never calls it.
 */
@Composable
fun App() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val facade = koinInject<AppConfigFacade>()
            ConfigSummaryCard(
                title = "Current App Configuration",
                brand = facade.brand,
                environment = facade.environment,
                appDisplayName = facade.appDisplayName,
                baseUrls = facade.apiBaseUrls,
                featureFlags = facade.featureFlags,
                modifier = Modifier.safeContentPadding().padding(16.dp),
            )
        }
    }
}

package com.hacker.kmmflavors.config

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hacker.core.config.BaseUrls
import com.hacker.core.config.Brand
import com.hacker.core.config.Environment
import com.hacker.core.config.FeatureFlags
import com.hacker.kmmflavors.getAppId

/**
 * Pure presentation: takes plain values rather than an AppConfigFacade or AppConfig, so it
 * doesn't need Koin and stays trivially previewable/testable.
 */
@Composable
fun ConfigSummaryCard(
    title: String,
    brand: Brand,
    environment: Environment,
    appDisplayName: String,
    baseUrls: BaseUrls,
    featureFlags: FeatureFlags,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Text(text = "Package Name: ${getAppId()}")
            ConfigRow("Brand", brand.name)
            ConfigRow("Environment", environment.name)
            ConfigRow("Display name", appDisplayName)
            ConfigRow("Accounts base URL", baseUrls.accounts)
            ConfigRow("Financials base URL", baseUrls.financial)
            ConfigRow("Promotions banner", featureFlags.isPromotionsBannerEnabled.toString())
            ConfigRow("Debug menu", featureFlags.isDebugMenuEnabled.toString())
        }
    }
}

@Composable
private fun ConfigRow(label: String, value: String) {
    Text(
        text = "$label: $value",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(top = 4.dp),
    )
}

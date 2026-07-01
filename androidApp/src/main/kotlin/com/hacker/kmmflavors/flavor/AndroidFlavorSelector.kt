package com.hacker.kmmflavors.flavor

import com.hacker.core.config.Brand
import com.hacker.core.config.BuildSelector
import com.hacker.core.config.Environment
import com.hacker.kmmflavors.BuildConfig

/**
 * Brand/environment come from the Gradle product flavor that produced this build, exposed via
 * BuildConfig fields. This is the only class in the project allowed to read BuildConfig -
 * everything below androidApp only ever sees the resulting [BuildSelector].
 */
class AndroidFlavorSelector : BuildSelector {
    override val brand: Brand =  Brand.valueOf(BuildConfig.BRAND.uppercase())
    override val environment: Environment = Environment.valueOf(BuildConfig.ENVIRONMENT.uppercase())
}

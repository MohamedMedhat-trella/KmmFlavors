package com.hacker.kmmflavors.flavor

import com.hacker.core.config.Brand
import com.hacker.core.config.BuildSelector
import com.hacker.core.config.Environment
import platform.Foundation.NSBundle

/**
 * Brand/environment come from the Xcode build configuration that produced this build: each
 * flavor's xcconfig sets APP_BRAND/APP_ENVIRONMENT, which Info.plist substitutes into the
 * AppBrand/AppEnvironment keys read here. This is the only class in the project allowed to
 * read those Info.plist keys - everything below the iOS entry point only ever sees the
 * resulting [BuildSelector].
 */
class IOSFlavorSelector : BuildSelector {
    private val infoDictionary = NSBundle.mainBundle.infoDictionary

    override val brand: Brand =
        Brand.valueOf((infoDictionary?.get("AppBrand") as? String).orEmpty().uppercase())
    override val environment: Environment =
        Environment.valueOf((infoDictionary?.get("AppEnvironment") as? String).orEmpty().uppercase())
}

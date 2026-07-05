package com.hacker.kmmflavors

import com.hacker.kmmflavors.config.initKoin
import com.hacker.kmmflavors.flavor.IOSFlavorSelector

/**
 * iOS equivalent of KmmFlavorsApplication.onCreate() on Android: the one call the platform
 * entry point (iOSApp.swift) makes before rendering anything, wiring Koin with the flavor
 * resolved from this build's Info.plist.
 */
fun startKoinIos() {
    initKoin(selector = IOSFlavorSelector())
}

package com.hacker.kmmflavors

import androidx.compose.runtime.Composable
import platform.Foundation.NSBundle
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

@Composable
actual fun getAppId(): String {
    return NSBundle.mainBundle.bundleIdentifier ?: "unknown"
}
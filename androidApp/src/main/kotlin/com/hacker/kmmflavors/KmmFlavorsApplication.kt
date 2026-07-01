package com.hacker.kmmflavors

import android.app.Application
import com.hacker.kmmflavors.config.initKoin
import com.hacker.kmmflavors.flavor.AndroidFlavorSelector

class KmmFlavorsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(selector = AndroidFlavorSelector())
    }
}

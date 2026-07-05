import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_11
    }
}
dependencies {
    implementation(projects.shared)

    implementation(libs.androidx.activity.compose)

    implementation(libs.compose.uiToolingPreview)
    debugImplementation(libs.compose.uiTooling)
}

android {
    namespace = "com.hacker.kmmflavors"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.hacker.kmmflavors"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        buildConfig = true
    }
    // Brand/environment still come from Gradle product flavors; AndroidFlavorSelector reads
    // them once at startup and hands a resolved AppConfig to Koin. Every module below
    // androidApp only ever sees AppConfig, never these flavors or BuildConfig directly.
    flavorDimensions += listOf("version", "environment")
    productFlavors {
        create("trella") {
            dimension = "version"
            buildConfigField("String", "BRAND", "\"trella\"")
        }
        create("ostouly") {
            dimension = "version"
            buildConfigField("String", "BRAND", "\"ostouly\"")
            applicationId = "com.hacker.ostouly"
        }
        create("staging") {
            dimension = "environment"
            buildConfigField("String", "ENVIRONMENT", "\"staging\"")
            applicationIdSuffix = ".staging"
        }
        create("production") {
            dimension = "environment"
            buildConfigField("String", "ENVIRONMENT", "\"production\"")
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}
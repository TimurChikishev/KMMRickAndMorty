plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = Versions.Android.compileSdk

    defaultConfig {
        applicationId = "com.swallow.kmmrickandmorty.android"
        minSdk = Versions.Android.minSdk
        targetSdk = Versions.Android.targetSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

withImplementation(
    Deps.AndroidX.appcompat,
    Deps.Android.Ui.material,
    Deps.Android.Ui.constraintLayout
)

dependencies {
    implementation(project(":shared"))
}
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

    buildFeatures {
        viewBinding = true
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
    }
}

withImplementation(
    Deps.AndroidX.appcompat,
    Deps.Android.Ui.material,
    Deps.Android.Ui.constraintLayout,
    Deps.AndroidX.Navigation.fragment,
    Deps.AndroidX.Navigation.ui,
    Deps.Android.ViewBinding.delegate,
    Deps.Android.Adapter.delegate,
    Deps.Android.Ui.Glide.core,
    Deps.MVI.coroutines,
    Deps.MVI.core,
    Deps.MVI.main,
    Deps.MVI.keepers,
    Deps.Koin.core,
    Deps.Koin.android,
    Deps.Logging.napier
)

dependencies {
    implementation(project(":shared"))
}
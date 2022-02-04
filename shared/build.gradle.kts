plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
    kotlin(Deps.Kotlin.Serialization.plugin) version Versions.kotlinVersion
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        //iosSimulatorArm64() sure all ios dependencies support this target
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Deps.Kotlin.Coroutines.native)
                implementation(Deps.MVI.main)
                implementation(Deps.MVI.core)
                implementation(Deps.MVI.coroutines)
                implementation(Deps.MVI.keepers)
                implementation(Deps.MVI.logging)
                implementation(Deps.Koin.core)
                implementation(Deps.Ktor.core)
                implementation(Deps.Ktor.utils)
                implementation(Deps.Ktor.serialization)
                implementation(Deps.Ktor.logging)
                implementation(Deps.Logging.napier)
                implementation(Deps.Kotlin.Serialization.json)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.Ktor.androidClient)
                implementation(Deps.Koin.android)
                implementation(Deps.Kotlin.Coroutines.android)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        //val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            //iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        //val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            //iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = Versions.Android.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Versions.Android.minSdk
        targetSdk = Versions.Android.targetSdk
    }

    dependencies {
        implementation(Deps.MVI.main)
        implementation(Deps.MVI.core)
        implementation(Deps.MVI.coroutines)
        implementation(Deps.MVI.keepers)
    }
}
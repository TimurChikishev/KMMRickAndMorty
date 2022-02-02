object Deps {
    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

        object Coroutines {
            private const val version = "1.6.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val native = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version-native-mt"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }
    }

    object Ktor {
        private const val version = "2.0.0-beta-1"
        const val core = "io.ktor:ktor-client-core:$version"
    }

    object Koin {
        private const val version = "3.1.5"
        const val core = "io.insert-koin:koin-core:$version"
        const val ktor = "io.insert-koin:koin-ktor:$version"
    }

    object Napier {
        private const val version = "2.4.0"
        const val napier = "io.github.aakira:napier:$version"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.0.4"

        object Ui {
            const val material = "com.google.android.material:material:1.5.0"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
        }
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"

        object Navigation {
            private const val version = "2.4.0"

            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgsPlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }
    }
}
object Deps {
    object Kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

        object Coroutines {
            private const val version = "1.6.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val native = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version-native-mt"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }

        object Serialization {
            const val plugin = "plugin.serialization"
            const val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
        }
    }

    object Ktor {
        private const val version = "1.6.1"
        const val core = "io.ktor:ktor-client-core:$version"
        const val androidClient = "io.ktor:ktor-client-okhttp:$version"
        const val serialization = "io.ktor:ktor-client-serialization:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val utils = "io.ktor:ktor-utils:$version"
    }

    object Koin {
        private const val version = "3.1.5"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
    }

    object Logging {
        const val napier = "io.github.aakira:napier:2.4.0"
    }

    object MVI {
        private const val version = "2.0.4"
        const val core = "com.arkivanov.mvikotlin:mvikotlin:$version"
        const val main = "com.arkivanov.mvikotlin:mvikotlin-main:$version"
        const val coroutines = "com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:$version"
        const val keepers = "com.arkivanov.mvikotlin:keepers:$version"
        const val logging = "com.arkivanov.mvikotlin:mvikotlin-logging:$version"
    }

    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:7.0.4"

        object Ui {
            const val material = "com.google.android.material:material:1.5.0"
            const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"

            object Glide {
                private const val version = "4.12.0"
                const val core = "com.github.bumptech.glide:glide:$version"
            }
        }

        object OkHttp {
            const val bom = "com.squareup.okhttp3:okhttp-bom:4.9.1"
            const val core = "com.squareup.okhttp3:okhttp"
        }

        object ViewBinding {
            private const val version = "1.5.3"
            const val delegate =  "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.3"
        }

        object Adapter {
            private const val version = "4.3.0"
            const val delegate =  "com.hannesdorfmann:adapterdelegates4:$version"
        }
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"

        object Lifecycle {
            private const val version = "2.4.0"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Navigation {
            private const val version = "2.4.0"

            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgsPlugin =
                "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }
    }
}
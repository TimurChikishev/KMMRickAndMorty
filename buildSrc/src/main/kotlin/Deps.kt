
object Deps {
    object Ktor {
        private const val version = "2.0.0-beta-1"
        const val core = "io.ktor:ktor-client-core:$version"
    }

    object Koin {
        private const val version = "3.1.5"
        const val core = "io.insert-koin:koin-core:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val ktor = "io.insert-koin:koin-ktor:$version"
    }
}
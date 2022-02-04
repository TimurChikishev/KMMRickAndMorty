package com.swallow.kmmrickandmorty.data.network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import org.koin.java.KoinJavaComponent.getKoin

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient(OkHttp) {
    engine {
        preconfigured = getKoin().get()
    }
    config(this)
}

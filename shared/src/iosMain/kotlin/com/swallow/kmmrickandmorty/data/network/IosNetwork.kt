package com.swallow.kmmrickandmorty.data.network

import io.ktor.client.*

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient = HttpClient()

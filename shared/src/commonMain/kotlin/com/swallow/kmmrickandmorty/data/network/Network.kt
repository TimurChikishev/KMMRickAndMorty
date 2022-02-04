package com.swallow.kmmrickandmorty.data.network

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient

fun HttpRequestBuilder.setApiHost() {
    url.protocol = URLProtocol.HTTPS
    url.host = "rickandmortyapi.com"
}

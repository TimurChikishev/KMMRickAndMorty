package com.swallow.kmmrickandmorty.di

import com.swallow.kmmrickandmorty.data.network.httpClient
import com.swallow.kmmrickandmorty.data.network.models.ErrorMessage
import com.swallow.kmmrickandmorty.data.network.models.NetworkException
import com.swallow.kmmrickandmorty.data.network.setApiHost
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

enum class NetworkClient {
    COMMON
}

val networkModule = module {
    single(named(NetworkClient.COMMON)) {
        httpClient {
            initBaseHttpConfig()
            defaultRequest { setApiHost() }
        }
    }
}

private fun HttpClientConfig<*>.initBaseHttpConfig() {
    HttpResponseValidator {
        val json = Json
        handleResponseException {
            val response = (it as? ResponseException)?.response ?: return@handleResponseException
            val status = response.status.value
            val exceptionResponse = response.readText()
            val url = response.call.request.url.toString()
            val errorMessage = json.decodeFromString(ErrorMessage.serializer(), exceptionResponse)
            throw NetworkException(url, status, errorMessage)
        }
    }

    install(Logging) {
        level = LogLevel.ALL
        logger = object : Logger {
            override fun log(message: String) {
                Napier.d(tag = "HTTP", message = message)
            }
        }
    }

    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

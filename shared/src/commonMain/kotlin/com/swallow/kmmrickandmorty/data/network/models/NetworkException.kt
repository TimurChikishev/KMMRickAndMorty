package com.swallow.kmmrickandmorty.data.network.models

data class NetworkException(
    val url: String,
    val status: Int,
    val errorMessage: ErrorMessage
) : RuntimeException("network exception|$url|$errorMessage")

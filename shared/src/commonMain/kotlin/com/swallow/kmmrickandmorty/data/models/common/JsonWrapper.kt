package com.swallow.kmmrickandmorty.data.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonWrapper<T>(
    @SerialName("info")
    val info: JsonInfo,
    @SerialName("results")
    val results: List<T>
)

package com.swallow.kmmrickandmorty.data.models.locations

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteLocations(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String,
    @SerialName("dimension")
    val dimension: String,
    @SerialName("residents")
    val residents: List<String>,
    @SerialName("url")
    val url: String,
    @SerialName("created")
    val created: String
)
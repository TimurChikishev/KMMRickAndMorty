package com.swallow.kmmrickandmorty.data.models.common

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class JsonInfo(
    @SerialName("count")
    val count: Int,
    @SerialName("pages")
    val pages: Int,
    @SerialName("next")
    val next: String?,
    @SerialName("prev")
    val prev: String?
)
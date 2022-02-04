package com.swallow.kmmrickandmorty.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorMessage(
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String
) {
    val userFormat = when (code) {
        "400_MII" -> "Member ID is not a number"
        "400_FNO" -> "File is not the exactly one"
        "400_FEM" -> "File exceeds the maximum size"
        // TODO add another options
        else -> null
    }
}

package com.swallow.kmmrickandmorty.data.models.characters

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacter(
    @SerialName("id")
    val id: Long,
    @SerialName("name")
    val name: String,
    @SerialName("status")
    val status: String,
    @SerialName("species")
    val species: String,
    @SerialName("type")
    val type: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("image")
    val image: String,
    @SerialName("url")
    val url: String,
    @SerialName("created")
    val created: String,
    @SerialName("origin")
    val origin: RemoteCharacterOrigin,
    @SerialName("location")
    val location: RemoteCharacterLocation,
    @SerialName("episode")
    val episode: List<String>
)

@Serializable
data class RemoteCharacterOrigin(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)

@Serializable
data class RemoteCharacterLocation(
    @SerialName("name")
    val name: String,
    @SerialName("url")
    val url: String
)


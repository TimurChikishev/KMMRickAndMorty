package com.swallow.kmmrickandmorty.data.models.characters

data class RemoteCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val created: String,
    val origin: RemoteCharacterOrigin,
    val location: RemoteCharacterLocation,
    val episode: List<String>
)

data class RemoteCharacterOrigin(
    val name: String,
    val url: String
)

data class RemoteCharacterLocation(
    val name: String,
    val url: String
)


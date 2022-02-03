package com.swallow.kmmrickandmorty.android.presentation.characters.model


data class UiCharacter(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val created: String,
    val origin: CharacterOrigin,
    val location: CharacterLocation,
    val episode: List<String>
)


data class CharacterOrigin(
    val name: String,
    val url: String
)

data class CharacterLocation(
    val name: String,
    val url: String
)



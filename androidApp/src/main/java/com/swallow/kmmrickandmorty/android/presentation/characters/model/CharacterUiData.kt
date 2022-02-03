package com.swallow.kmmrickandmorty.android.presentation.characters.model

sealed class CharacterUiData {
    data class Character(
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
    ) : CharacterUiData()
}

data class CharacterOrigin(
    val name: String,
    val url: String
)

data class CharacterLocation(
    val name: String,
    val url: String
)



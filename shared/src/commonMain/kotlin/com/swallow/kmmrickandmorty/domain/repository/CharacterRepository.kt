package com.swallow.kmmrickandmorty.domain.repository

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter

interface CharacterRepository {
    suspend fun getCharacters() : List<RemoteCharacter>
}
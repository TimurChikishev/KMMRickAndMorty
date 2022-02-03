package com.swallow.kmmrickandmorty.data.repository

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository

class CharacterRepositoryImpl : CharacterRepository {

    override suspend fun getCharacters(): List<RemoteCharacter> {
        TODO("Not yet implemented")
    }

}
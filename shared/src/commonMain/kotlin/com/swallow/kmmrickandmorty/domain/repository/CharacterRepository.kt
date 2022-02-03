package com.swallow.kmmrickandmorty.domain.repository

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.common.JsonWrapper

interface CharacterRepository {
    suspend fun getCharacters() : JsonWrapper<RemoteCharacter>
}
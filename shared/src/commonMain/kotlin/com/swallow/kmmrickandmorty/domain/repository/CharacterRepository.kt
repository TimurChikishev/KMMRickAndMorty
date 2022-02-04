package com.swallow.kmmrickandmorty.domain.repository

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.common.JsonInfo
import com.swallow.kmmrickandmorty.data.models.common.JsonWrapper

interface CharacterRepository {
    suspend fun getCharacters(jsonInfo: JsonInfo? = null) : JsonWrapper<RemoteCharacter>
}
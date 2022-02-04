package com.swallow.kmmrickandmorty.data.repository

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.common.JsonInfo
import com.swallow.kmmrickandmorty.data.models.common.JsonWrapper
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import com.swallow.kmmrickandmorty.utils.ioDispatcher
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.withContext

class CharacterRepositoryImpl(
    private val httpClient: HttpClient
) : CharacterRepository {

    override suspend fun getCharacters(jsonInfo: JsonInfo?): JsonWrapper<RemoteCharacter> = withContext(ioDispatcher) {
        val url = jsonInfo?.next ?: "/api/character"
        httpClient.get(url)
    }
}
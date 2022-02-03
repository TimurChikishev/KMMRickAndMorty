package com.swallow.kmmrickandmorty.data.repository

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.common.JsonWrapper
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import com.swallow.kmmrickandmorty.utils.ioDispatcher
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.withContext

class CharacterRepositoryImpl(
    private val httpClient: HttpClient
) : CharacterRepository {

    override suspend fun getCharacters(): JsonWrapper<RemoteCharacter> = withContext(ioDispatcher) {
        httpClient.get("/api/character")
    }
}
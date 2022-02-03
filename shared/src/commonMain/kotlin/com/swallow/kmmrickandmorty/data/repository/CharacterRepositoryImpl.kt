package com.swallow.kmmrickandmorty.data.repository

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.common.JsonWrapper
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class CharacterRepositoryImpl(
    private val httpClient: HttpClient,
    private val json: Json
) : CharacterRepository {

    override suspend fun getCharacters(): JsonWrapper<RemoteCharacter> {
        return httpClient.get("/api/character")
    }
}
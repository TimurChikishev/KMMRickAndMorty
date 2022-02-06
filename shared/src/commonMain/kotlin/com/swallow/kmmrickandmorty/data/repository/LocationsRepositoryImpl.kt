package com.swallow.kmmrickandmorty.data.repository

import com.swallow.kmmrickandmorty.data.models.common.JsonInfo
import com.swallow.kmmrickandmorty.data.models.common.JsonWrapper
import com.swallow.kmmrickandmorty.data.models.locations.RemoteLocations
import com.swallow.kmmrickandmorty.domain.repository.GetRepository
import com.swallow.kmmrickandmorty.utils.ioDispatcher
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.withContext

class LocationsRepositoryImpl(
    private val httpClient: HttpClient,
    private val defaultUrl: String
) : GetRepository<RemoteLocations> {

    override suspend fun get(jsonInfo: JsonInfo?): JsonWrapper<RemoteLocations> = withContext(ioDispatcher) {
        val url = jsonInfo?.next ?: defaultUrl
        httpClient.get(url)
    }
}
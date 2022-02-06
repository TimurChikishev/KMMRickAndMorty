package com.swallow.kmmrickandmorty.di

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.episodes.RemoteEpisode
import com.swallow.kmmrickandmorty.data.models.locations.RemoteLocations
import com.swallow.kmmrickandmorty.data.repository.CharactersRepositoryImpl
import com.swallow.kmmrickandmorty.data.repository.EpisodesRepositoryImpl
import com.swallow.kmmrickandmorty.data.repository.LocationsRepositoryImpl
import com.swallow.kmmrickandmorty.domain.repository.GetRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module

enum class RepositoryType {
    CHARACTER,
    LOCATION,
    EPISODE
}

val repositoryModule = module {

    single<GetRepository<RemoteCharacter>>(named(RepositoryType.CHARACTER)) {
        CharactersRepositoryImpl(
            httpClient = get(named(NetworkClient.COMMON)),
            defaultUrl = "/api/character"
        )
    }

    single<GetRepository<RemoteLocations>>(named(RepositoryType.LOCATION)) {
        LocationsRepositoryImpl(
            httpClient = get(named(NetworkClient.COMMON)),
            defaultUrl = "/api/location"
        )
    }

    single<GetRepository<RemoteEpisode>>(named(RepositoryType.EPISODE)) {
        EpisodesRepositoryImpl(
            httpClient = get(named(NetworkClient.COMMON)),
            defaultUrl = "/api/episode"
        )
    }
}
package com.swallow.kmmrickandmorty.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.episodes.RemoteEpisode
import com.swallow.kmmrickandmorty.data.models.locations.RemoteLocations
import com.swallow.kmmrickandmorty.domain.stores.common.ListStoreFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

enum class StoreType {
    CHARACTER,
    LOCATION,
    EPISODE
}

val storeModule = module {
    factory<StoreFactory> { DefaultStoreFactory }

    factory(named(StoreType.CHARACTER)){
        ListStoreFactory<RemoteCharacter>(
            storeFactory = get(),
            repository = get(named(RepositoryType.CHARACTER)),
        ).create()
    }

    factory(named(StoreType.LOCATION)) {
        ListStoreFactory<RemoteLocations>(
            storeFactory = get(),
            repository = get(named(RepositoryType.LOCATION)),
        ).create()
    }

    factory(named(StoreType.EPISODE)) {
        ListStoreFactory<RemoteEpisode>(
            storeFactory = get(),
            repository = get(named(RepositoryType.EPISODE)),
        ).create()
    }
}
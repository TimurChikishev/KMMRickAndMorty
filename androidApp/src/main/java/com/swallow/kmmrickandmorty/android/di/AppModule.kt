package com.swallow.kmmrickandmorty.android.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.keepers.instancekeeper.ExperimentalInstanceKeeperApi
import com.arkivanov.mvikotlin.keepers.instancekeeper.InstanceKeeper
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.swallow.kmmrickandmorty.data.repository.CharacterRepositoryImpl
import com.swallow.kmmrickandmorty.domain.controller.characters.CharactersCoroutinesController
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import org.koin.dsl.module

@OptIn(ExperimentalInstanceKeeperApi::class)
val appModule = module {
    factory<StoreFactory>{ DefaultStoreFactory }

    factory { (instanceKeeper : InstanceKeeper) ->
        CharactersCoroutinesController(
            storeFactory = get(),
            charactersRepository = get(),
            instanceKeeper = instanceKeeper
        )
    }
}
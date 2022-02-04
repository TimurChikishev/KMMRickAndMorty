package com.swallow.kmmrickandmorty.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStoreFactory
import org.koin.dsl.module

val appModuleShared = module {
    factory<StoreFactory> { DefaultStoreFactory }

    factory {
        CharactersStoreFactory(
            storeFactory = get(),
            charactersRepository = get(),
        ).create()
    }
}

package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStore.*
import kotlinx.coroutines.CoroutineDispatcher

class CharactersStoreFactory(
    private val storeFactory: StoreFactory,
    private val initialState: State,
    private val charactersRepository: CharacterRepository,
    private val mainContext: CoroutineDispatcher
) {

    fun create(): CharactersStore =
        object : CharactersStore, Store<Intent, State, Label> by storeFactory.create(
            name = CHARACTERS_STORE_NAME,
            initialState = initialState,
            bootstrapper = CharacterBootstrapperImpl(),
            executorFactory = { CharactersExecutorImpl(charactersRepository, mainContext) },
            reducer = CharacterReducerImpl()
        ) {}

    companion object {
        private const val CHARACTERS_STORE_NAME = "CHARACTERS_STORE_NAME"
    }
}
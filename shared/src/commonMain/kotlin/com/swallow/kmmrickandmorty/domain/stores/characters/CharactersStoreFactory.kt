package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStore.*
import com.swallow.kmmrickandmorty.utils.mainDispatcher
import kotlinx.coroutines.CoroutineDispatcher

class CharactersStoreFactory(
    private val storeFactory: StoreFactory,
    private val charactersRepository: CharacterRepository,
    private val mainContext: CoroutineDispatcher = mainDispatcher
) {

    fun create(): CharactersStore =
        object : CharactersStore, Store<Intent, State, Label> by storeFactory.create(
            name = CHARACTERS_STORE_NAME,
            initialState = State(),
            bootstrapper = CharacterBootstrapperImpl(),
            executorFactory = { CharactersExecutorImpl(charactersRepository, mainContext) },
            reducer = CharacterReducerImpl()
        ) {}

    companion object {
        private const val CHARACTERS_STORE_NAME = "CHARACTERS_STORE_NAME"
    }
}
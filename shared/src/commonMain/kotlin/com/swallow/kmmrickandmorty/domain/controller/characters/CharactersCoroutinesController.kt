package com.swallow.kmmrickandmorty.domain.controller.characters

import com.arkivanov.mvikotlin.core.binder.BinderLifecycleMode
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.lifecycle.Lifecycle
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.arkivanov.mvikotlin.keepers.instancekeeper.ExperimentalInstanceKeeperApi
import com.arkivanov.mvikotlin.keepers.instancekeeper.InstanceKeeper
import com.swallow.kmmrickandmorty.domain.mappers.characters.charactersStateToCharactersModel
import com.swallow.kmmrickandmorty.domain.mvi_view.characters.CharactersView
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStore
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStoreFactory
import com.swallow.kmmrickandmorty.utils.mainDispatcher
import com.swallow.kmmrickandmorty.utils.mapNotNull
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi

class CharactersCoroutinesController constructor(
    private val storeFactory: StoreFactory,
    private val charactersRepository: CharacterRepository,
    @OptIn(ExperimentalInstanceKeeperApi::class)
    private val instanceKeeper: InstanceKeeper,
    private val mainContext: CoroutineDispatcher = mainDispatcher
) : CharactersController {

    @OptIn(ExperimentalInstanceKeeperApi::class)
    private val charactersStore = instanceKeeper.getStore {
        CharactersStoreFactory(
            storeFactory = storeFactory,
            initialState = CharactersStore.State(),
            charactersRepository = charactersRepository,
            mainContext = mainContext
        ).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onViewCreated(charactersView: CharactersView, viewLifecycle: Lifecycle) {
        bind(viewLifecycle, BinderLifecycleMode.START_STOP, mainContext) {
            charactersStore.states.mapNotNull(charactersStateToCharactersModel) bindTo charactersView
        }
    }
}
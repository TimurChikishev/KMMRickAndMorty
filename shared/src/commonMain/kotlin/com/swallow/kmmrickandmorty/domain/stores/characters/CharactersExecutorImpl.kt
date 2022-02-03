package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineDispatcher

class CharactersExecutorImpl(
    private val charactersRepository: CharacterRepository,
    mainContext: CoroutineDispatcher
) : SuspendExecutor<
        CharactersStore.Intent,
        CharacterAction,
        CharactersStore.State,
        CharacterResult,
        CharactersStore.Label>(mainContext = mainContext) {

    override suspend fun executeAction(action: CharacterAction, getState: () -> CharactersStore.State) {
        when (action) {
            is CharacterAction.Initial -> initial()
        }
    }

    override suspend fun executeIntent(intent: CharactersStore.Intent, getState: () -> CharactersStore.State) {
        when (intent) {
            is CharactersStore.Intent.LoadingList -> Unit
        }
    }

    private suspend fun initial() {
        val wrapper = charactersRepository.getCharacters()
        dispatch(CharacterResult.Loaded(wrapper.results))
    }
}
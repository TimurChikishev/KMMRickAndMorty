package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import com.swallow.kmmrickandmorty.domain.common.LoadState
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
            is CharacterAction.Initial -> loadingList(getState())
        }
    }

    override suspend fun executeIntent(intent: CharactersStore.Intent, getState: () -> CharactersStore.State) {
        when (intent) {
            is CharactersStore.Intent.LoadingList -> loadingList(getState())
            is CharactersStore.Intent.LoadingPage -> loadingPage(getState())
            is CharactersStore.Intent.Retry -> retry(getState())
        }
    }

    private suspend fun retry(state: CharactersStore.State) {
        when(state.loadState){
            is LoadState.ErrorList -> retryList()
            is LoadState.NextPageError -> retryPage(state)
            else -> return
        }
    }

    private suspend fun retryList(){
        dispatch(CharacterResult.UpdateLoadState(LoadState.LoadingList))

        try {
            val jsonWrapper = charactersRepository.getCharacters()
            dispatch(CharacterResult.Loaded(jsonWrapper))
            dispatch(CharacterResult.UpdateLoadState(LoadState.SuccessList))
        } catch (t: Throwable) {
            dispatch(CharacterResult.UpdateLoadState(LoadState.ErrorList))
        }
    }

    private suspend fun retryPage(state: CharactersStore.State){
        dispatch(CharacterResult.UpdateLoadState(LoadState.LoadingPage))

        try {
            val jsonWrapper = charactersRepository.getCharacters(state.jsonInfo)
            dispatch(CharacterResult.LoadedPage(jsonWrapper))
            dispatch(CharacterResult.UpdateLoadState(LoadState.NextPageSuccess))
        } catch (t: Throwable) {
            dispatch(CharacterResult.UpdateLoadState(LoadState.NextPageError))
        }
    }

    private suspend fun loadingPage(state: CharactersStore.State) {
        if(isLoadingOrError(state)) return

        dispatch(CharacterResult.UpdateLoadState(LoadState.LoadingPage))

        try {
            val jsonWrapper = charactersRepository.getCharacters(state.jsonInfo)
            dispatch(CharacterResult.LoadedPage(jsonWrapper))
            dispatch(CharacterResult.UpdateLoadState(LoadState.NextPageSuccess))
        } catch (t: Throwable) {
            dispatch(CharacterResult.UpdateLoadState(LoadState.NextPageError))
        }
    }

    private suspend fun loadingList(state: CharactersStore.State) {

        if(isLoadingOrError(state)) return

        dispatch(CharacterResult.UpdateLoadState(LoadState.LoadingList))

        try {
            val jsonWrapper = charactersRepository.getCharacters()
            dispatch(CharacterResult.Loaded(jsonWrapper))
            dispatch(CharacterResult.UpdateLoadState(LoadState.SuccessList))
        } catch (t: Throwable) {
            dispatch(CharacterResult.UpdateLoadState(LoadState.ErrorList))
        }
    }

    private fun isLoadingOrError(state: CharactersStore.State): Boolean {
        return state.loadState is LoadState.LoadingList
                || state.loadState is LoadState.LoadingPage
                || state.loadState is LoadState.ErrorList
                || state.loadState is LoadState.NextPageError
    }
}
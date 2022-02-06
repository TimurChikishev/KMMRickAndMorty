package com.swallow.kmmrickandmorty.domain.stores.common

import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import com.swallow.kmmrickandmorty.domain.common.LoadState
import com.swallow.kmmrickandmorty.domain.repository.GetRepository
import io.github.aakira.napier.Napier
import kotlinx.coroutines.CoroutineDispatcher

class ExecutorImpl<Model : Any>(
    private val repository: GetRepository<Model>,
    mainContext: CoroutineDispatcher
) : SuspendExecutor<
        ListStore.Intent,
        Action,
        ListStore.State<Model>,
        Result,
        ListStore.Label>(mainContext = mainContext) {

    override suspend fun executeAction(action: Action, getState: () -> ListStore.State<Model>) {
        when (action) {
            is Action.Initial -> loadingList(getState())
        }
    }

    override suspend fun executeIntent(intent: ListStore.Intent, getState: () -> ListStore.State<Model>) {
        when (intent) {
            is ListStore.Intent.LoadingList -> loadingList(getState())
            is ListStore.Intent.LoadingPage -> loadingPage(getState())
            is ListStore.Intent.Retry -> retry(getState())
        }
    }

    private suspend fun retry(state: ListStore.State<Model>) {
        when(state.loadState){
            is LoadState.ErrorList -> retryList()
            is LoadState.NextPageError -> retryPage(state)
            else -> return
        }
    }

    private suspend fun retryList(){
        dispatch(Result.UpdateLoadState(LoadState.LoadingList))

        try {
            val jsonWrapper = repository.get()
            dispatch(Result.Loaded(jsonWrapper))
            dispatch(Result.UpdateLoadState(LoadState.SuccessList))
        } catch (t: Throwable) {
            dispatch(Result.UpdateLoadState(LoadState.ErrorList))
        }
    }

    private suspend fun retryPage(state: ListStore.State<Model>){
        dispatch(Result.UpdateLoadState(LoadState.LoadingPage))

        try {
            val jsonWrapper = repository.get(state.jsonInfo)
            dispatch(Result.LoadedPage(jsonWrapper))
            dispatch(Result.UpdateLoadState(LoadState.NextPageSuccess))
        } catch (t: Throwable) {
            dispatch(Result.UpdateLoadState(LoadState.NextPageError))
        }
    }

    private suspend fun loadingPage(state: ListStore.State<Model>) {
        if(isLoadingOrError(state)) return

        dispatch(Result.UpdateLoadState(LoadState.LoadingPage))

        try {
            val jsonWrapper = repository.get(state.jsonInfo)
            dispatch(Result.LoadedPage(jsonWrapper))
            dispatch(Result.UpdateLoadState(LoadState.NextPageSuccess))
        } catch (t: Throwable) {
            dispatch(Result.UpdateLoadState(LoadState.NextPageError))
        }
    }

    private suspend fun loadingList(state: ListStore.State<Model>) {

        if(isLoadingOrError(state)) return

        dispatch(Result.UpdateLoadState(LoadState.LoadingList))

        try {
            val jsonWrapper = repository.get()
            dispatch(Result.Loaded(jsonWrapper))
            dispatch(Result.UpdateLoadState(LoadState.SuccessList))
        } catch (t: Throwable) {
            Napier.w(throwable = t, message = "loading list error")
            dispatch(Result.UpdateLoadState(LoadState.ErrorList))
        }
    }

    private fun isLoadingOrError(state: ListStore.State<Model>): Boolean {
        return state.loadState is LoadState.LoadingList
                || state.loadState is LoadState.LoadingPage
                || state.loadState is LoadState.ErrorList
                || state.loadState is LoadState.NextPageError
    }
}
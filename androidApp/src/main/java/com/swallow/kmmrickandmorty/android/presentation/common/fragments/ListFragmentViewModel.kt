package com.swallow.kmmrickandmorty.android.presentation.common.fragments

import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.swallow.kmmrickandmorty.android.presentation.common.base.BaseViewModel
import com.swallow.kmmrickandmorty.android.presentation.common.mappers.StateMapper
import com.swallow.kmmrickandmorty.domain.stores.common.ListStore
import com.swallow.kmmrickandmorty.utils.mapNotNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

class ListFragmentViewModel<RemoteModel : Any, UiState : Any>(
    private val store: ListStore<RemoteModel>,
    private val mapper: StateMapper<ListStore.State<RemoteModel>, UiState>,
    initialState: UiState
) : BaseViewModel<UiState, ListStore.Label>(initialState) {

    val state: Flow<UiState> = mutableState

    @OptIn(ExperimentalCoroutinesApi::class)
    fun init() {
        bind {
            store.states.mapNotNull(mapper::map) bindTo ::acceptState
        }.apply {
            start()
        }
    }

    override fun loadingNextPage() {
        store.accept(ListStore.Intent.LoadingPage)
    }

    override fun retry() {
        store.accept(ListStore.Intent.Retry)
    }
}
package com.swallow.kmmrickandmorty.domain.stores.common

import com.arkivanov.mvikotlin.core.store.Store
import com.swallow.kmmrickandmorty.data.models.common.JsonInfo
import com.swallow.kmmrickandmorty.domain.common.LoadState
import com.swallow.kmmrickandmorty.domain.stores.common.ListStore.*

interface ListStore<Model : Any> : Store<Intent, State<Model>, Label> {

    sealed class Intent {
        object LoadingList : Intent()
        object LoadingPage : Intent()
        object Retry : Intent()
    }

    data class State<Model : Any>(
        val items: List<Model> = emptyList(),
        val loadState: LoadState = LoadState.SuccessList,
        val jsonInfo: JsonInfo = JsonInfo(
            count = 0,
            pages = 0,
            next = null,
            prev = null
        )
    )

    sealed class Label
}

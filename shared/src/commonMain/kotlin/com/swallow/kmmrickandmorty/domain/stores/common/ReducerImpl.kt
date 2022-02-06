package com.swallow.kmmrickandmorty.domain.stores.common

import com.arkivanov.mvikotlin.core.store.Reducer

class ReducerImpl<Model : Any> : Reducer<ListStore.State<Model>, Result> {

    @Suppress("UNCHECKED_CAST")
    override fun ListStore.State<Model>.reduce(result: Result): ListStore.State<Model> =
        when (result) {
            is Result.Loaded<*> -> copy(
                items = result.items.results as List<Model>,
                jsonInfo = result.items.info
            )
            is Result.LoadedPage<*> -> copy(
                items = items + result.items.results as List<Model>,
                jsonInfo = result.items.info
            )
            is Result.UpdateLoadState -> copy(loadState = result.loadState)
        }
}
package com.swallow.kmmrickandmorty.android.presentation.common.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.swallow.kmmrickandmorty.android.presentation.common.adapters.items.CharacterItemDelegate
import com.swallow.kmmrickandmorty.android.presentation.common.adapters.items.LoadStateItemDelegate
import com.swallow.kmmrickandmorty.android.presentation.common.adapters.items.LocationItemDelegate
import com.swallow.kmmrickandmorty.android.presentation.common.model.ListState
import com.swallow.kmmrickandmorty.android.presentation.common.model.LoadStateItem
import com.swallow.kmmrickandmorty.domain.common.LoadState

class ComplexDelegatesAdapter(
    retry: () -> Unit
) : AsyncListDifferDelegationAdapter<Any>(ComplexDiffCallback()) {

    init {
        delegatesManager
            .addDelegate(LocationItemDelegate())
            .addDelegate(CharacterItemDelegate())
            .addDelegate(LoadStateItemDelegate(retry))
    }

    fun <Model, UiState : ListState<Model>> updateLoadStateItem(state: UiState) {
        when (state.loadState) {
            is LoadState.LoadingPage -> {
                if (items.lastOrNull() is LoadStateItem) return
                addLoadStateItem(state.loadState)
            }
            is LoadState.NextPageError -> {
                addLoadStateItem(state.loadState)
            }
            else -> items = state.items
        }
    }

    private fun addLoadStateItem(loadState: LoadState) {
        items = items.toMutableList().apply {
            if (lastOrNull() is LoadStateItem) {
                removeLastOrNull()
            }
            add(LoadStateItem(loadState = loadState))
        }
    }
}
package com.swallow.kmmrickandmorty.android.presentation.characters.mvi_view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.arkivanov.mvikotlin.core.utils.diff
import com.arkivanov.mvikotlin.core.view.BaseMviView
import com.arkivanov.mvikotlin.core.view.ViewRenderer
import com.swallow.kmmrickandmorty.android.R
import com.swallow.kmmrickandmorty.android.presentation.common.adapters.ComplexDelegatesAdapter
import com.swallow.kmmrickandmorty.domain.mvi_view.characters.CharactersView

class CharactersViewImpl(
    root: View
) : BaseMviView<CharactersView.Model, CharactersView.Event>(), CharactersView {

    private var listAdapter: ComplexDelegatesAdapter = ComplexDelegatesAdapter()

        override val renderer: ViewRenderer<CharactersView.Model> = diff {
        diff(get = CharactersView.Model::items, compare = { a, b -> a === b }, set = {
            listAdapter.items = it
        })
    }

    init {
        root.findViewById<RecyclerView>(R.id.recyclerView).adapter = listAdapter
    }
}
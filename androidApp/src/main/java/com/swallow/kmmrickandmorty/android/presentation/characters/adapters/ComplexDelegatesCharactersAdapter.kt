package com.swallow.kmmrickandmorty.android.presentation.characters.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.swallow.kmmrickandmorty.android.presentation.characters.adapters.items.SimpleItemCharacterAdapter

class ComplexDelegatesCharactersAdapter
    : AsyncListDifferDelegationAdapter<Any>(ComplexDiffCallback()) {

    init {
        delegatesManager
            .addDelegate(SimpleItemCharacterAdapter())
    }
}
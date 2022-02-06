package com.swallow.kmmrickandmorty.android.presentation.common.adapters.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.swallow.kmmrickandmorty.android.databinding.ItemCharactersBinding
import com.swallow.kmmrickandmorty.android.presentation.characters.model.Character
import com.swallow.kmmrickandmorty.android.presentation.common.adapters.viewholders.CharacterViewHolder

class CharacterItemDelegate : AbsListItemAdapterDelegate<Any, Any, CharacterViewHolder>() {

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is Character
    }

    override fun onCreateViewHolder(parent: ViewGroup) = CharacterViewHolder(
        ItemCharactersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        item: Any,
        holder: CharacterViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item as Character)
    }
}
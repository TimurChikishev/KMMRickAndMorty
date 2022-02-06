package com.swallow.kmmrickandmorty.android.presentation.common.adapters.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.swallow.kmmrickandmorty.android.databinding.ItemEpisodesBinding
import com.swallow.kmmrickandmorty.android.presentation.common.adapters.viewholders.EpisodeViewHolder
import com.swallow.kmmrickandmorty.android.presentation.episodes.models.Episode

class EpisodeItemDelegate : AbsListItemAdapterDelegate<Any, Any, EpisodeViewHolder>() {

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is Episode
    }

    override fun onCreateViewHolder(parent: ViewGroup) = EpisodeViewHolder(
        ItemEpisodesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        item: Any,
        holder: EpisodeViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item as Episode)
    }
}
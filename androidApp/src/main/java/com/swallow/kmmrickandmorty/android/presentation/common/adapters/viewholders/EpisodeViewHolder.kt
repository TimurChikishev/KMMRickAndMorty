package com.swallow.kmmrickandmorty.android.presentation.common.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.swallow.kmmrickandmorty.android.databinding.ItemEpisodesBinding
import com.swallow.kmmrickandmorty.android.presentation.episodes.models.Episode

class EpisodeViewHolder(
    private val viewBinding: ItemEpisodesBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(model: Episode) = with(model) {
        setDate(airDate)
        setName(name)
    }

    private fun setDate(date: String) {
        viewBinding.date.text = date
    }

    private fun setName(name: String) {
        viewBinding.name.text = name
    }
}
package com.swallow.kmmrickandmorty.android.presentation.common.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.swallow.kmmrickandmorty.android.databinding.ItemLocationsBinding
import com.swallow.kmmrickandmorty.android.presentation.locations.model.Locations

class LocationViewHolder(
    private val viewBinding: ItemLocationsBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(model: Locations) = with(model) {
        setDimension(dimension)
        setType(type)
        setName(name)
    }

    private fun setType(type: String) {
        viewBinding.type.text = type
    }

    private fun setDimension(dimension: String) {
        viewBinding.dimension.text = dimension
    }

    private fun setName(name: String) {
        viewBinding.name.text = name
    }
}
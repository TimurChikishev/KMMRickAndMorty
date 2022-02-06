package com.swallow.kmmrickandmorty.android.presentation.common.adapters.items

import android.view.LayoutInflater
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.swallow.kmmrickandmorty.android.databinding.ItemLocationsBinding
import com.swallow.kmmrickandmorty.android.presentation.common.adapters.viewholders.LocationViewHolder
import com.swallow.kmmrickandmorty.android.presentation.locations.model.Locations
import io.github.aakira.napier.Napier

class LocationItemDelegate : AbsListItemAdapterDelegate<Any, Any, LocationViewHolder>() {

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        Napier.d(message = "isForViewType=$item")
        return item is Locations
    }

    override fun onCreateViewHolder(parent: ViewGroup) = LocationViewHolder(
        ItemLocationsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        item: Any,
        holder: LocationViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item as Locations)
    }
}
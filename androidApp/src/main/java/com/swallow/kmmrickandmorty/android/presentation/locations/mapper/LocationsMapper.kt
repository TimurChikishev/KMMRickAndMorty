package com.swallow.kmmrickandmorty.android.presentation.locations.mapper

import com.swallow.kmmrickandmorty.android.presentation.characters.model.ListUiState
import com.swallow.kmmrickandmorty.android.presentation.common.mappers.StateMapper
import com.swallow.kmmrickandmorty.android.presentation.locations.model.Locations
import com.swallow.kmmrickandmorty.data.models.locations.RemoteLocations
import com.swallow.kmmrickandmorty.domain.stores.common.ListStore

class LocationsMapper : StateMapper<ListStore.State<RemoteLocations>, ListUiState<Locations>> {
    override fun map(state: ListStore.State<RemoteLocations>): ListUiState<Locations> {
        return ListUiState(
            items = state.items.map { it.mapToUi },
            loadState = state.loadState
        )
    }

    private val RemoteLocations.mapToUi: Locations
        get() = Locations(
            id = id,
            name = name,
            type = type,
            dimension = dimension,
            residents = residents,
            url = url,
            created = created
        )
}
package com.swallow.kmmrickandmorty.android.presentation.episodes.mapper

import com.swallow.kmmrickandmorty.android.presentation.characters.model.ListUiState
import com.swallow.kmmrickandmorty.android.presentation.common.mappers.StateMapper
import com.swallow.kmmrickandmorty.android.presentation.episodes.models.Episode
import com.swallow.kmmrickandmorty.data.models.episodes.RemoteEpisode
import com.swallow.kmmrickandmorty.domain.stores.common.ListStore

class EpisodesMapper : StateMapper<ListStore.State<RemoteEpisode>, ListUiState<Episode>> {

    override fun map(state: ListStore.State<RemoteEpisode>): ListUiState<Episode> {
        return ListUiState(
            items = state.items.map { it.mapToUi },
            loadState = state.loadState
        )
    }

    private val RemoteEpisode.mapToUi: Episode
        get() = Episode(
            id = id,
            name = name,
            url = url,
            created = created,
            episode = episode,
            airDate = airDate,
            characters = characters
        )
}



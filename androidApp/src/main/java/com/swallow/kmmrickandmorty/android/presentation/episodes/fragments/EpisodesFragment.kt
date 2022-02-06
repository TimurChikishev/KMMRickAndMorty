package com.swallow.kmmrickandmorty.android.presentation.episodes.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.swallow.kmmrickandmorty.android.di.ViewModelType
import com.swallow.kmmrickandmorty.android.presentation.characters.model.ListUiState
import com.swallow.kmmrickandmorty.android.presentation.common.fragments.ListFragment
import com.swallow.kmmrickandmorty.android.presentation.episodes.models.Episode
import com.swallow.kmmrickandmorty.data.models.episodes.RemoteEpisode

class EpisodesFragment
    : ListFragment<RemoteEpisode, Episode, ListUiState<Episode>>(ViewModelType.EPISODE) {

    override lateinit var linerLayoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        linerLayoutManager = LinearLayoutManager(requireContext())
        super.onViewCreated(view, savedInstanceState)
    }
}
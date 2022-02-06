package com.swallow.kmmrickandmorty.android.presentation.locations.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.swallow.kmmrickandmorty.android.di.ViewModelType
import com.swallow.kmmrickandmorty.android.presentation.characters.model.ListUiState
import com.swallow.kmmrickandmorty.android.presentation.common.fragments.ListFragment
import com.swallow.kmmrickandmorty.android.presentation.locations.model.Locations
import com.swallow.kmmrickandmorty.data.models.locations.RemoteLocations

class LocationsFragment
    : ListFragment<RemoteLocations, Locations, ListUiState<Locations>>(ViewModelType.LOCATION) {

    override lateinit var linerLayoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        linerLayoutManager = LinearLayoutManager(requireContext())
        super.onViewCreated(view, savedInstanceState)
    }
}

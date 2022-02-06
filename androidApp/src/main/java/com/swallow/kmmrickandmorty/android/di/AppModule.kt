package com.swallow.kmmrickandmorty.android.di

import com.swallow.kmmrickandmorty.android.presentation.characters.mapper.CharactersMapper
import com.swallow.kmmrickandmorty.android.presentation.characters.model.ListUiState
import com.swallow.kmmrickandmorty.android.presentation.common.fragments.ListFragmentViewModel
import com.swallow.kmmrickandmorty.android.presentation.locations.mapper.LocationsMapper
import com.swallow.kmmrickandmorty.di.StoreType
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

enum class ViewModelType{
    CHARACTER,
    LOCATION
}

val appModule = module {

    viewModel(named(ViewModelType.CHARACTER)) {
        ListFragmentViewModel(
            store = get(named(StoreType.CHARACTER)),
            mapper = CharactersMapper(),
            initialState = ListUiState()
        )
    }

    viewModel(named(ViewModelType.LOCATION)) {
        ListFragmentViewModel(
            store = get(named(StoreType.LOCATION)),
            mapper = LocationsMapper(),
            initialState = ListUiState()
        )
    }
}
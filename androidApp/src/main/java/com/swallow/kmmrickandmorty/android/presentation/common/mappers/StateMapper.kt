package com.swallow.kmmrickandmorty.android.presentation.common.mappers

interface StateMapper<RemoteState, UiState> {
    fun map(state: RemoteState): UiState
}
package com.swallow.kmmrickandmorty.android.presentation.characters.model

import com.swallow.kmmrickandmorty.android.presentation.common.model.ListState
import com.swallow.kmmrickandmorty.domain.common.LoadState

data class ListUiState<Model : Any>(
    override val items: List<Model> = emptyList(),
    override val loadState: LoadState = LoadState.SuccessList
) : ListState<Model>
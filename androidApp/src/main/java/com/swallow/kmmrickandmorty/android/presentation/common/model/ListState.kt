package com.swallow.kmmrickandmorty.android.presentation.common.model

import com.swallow.kmmrickandmorty.domain.common.LoadState

interface ListState<Model : Any> {
    val items: List<Model>
    val loadState: LoadState
}
package com.swallow.kmmrickandmorty.android.presentation.common.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel<State : Any, Label : Any>(
    initialState: State
) : ViewModel() {

    protected val mutableState = MutableStateFlow(initialState)
    protected val mutableLabel = Channel<Label>()

    protected fun acceptState(state: State) {
        mutableState.value = state
    }

    abstract fun loadingNextPage()

    abstract fun retry()
}
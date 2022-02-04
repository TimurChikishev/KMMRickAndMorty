package com.swallow.kmmrickandmorty.android.presentation.characters.fragments

import androidx.lifecycle.ViewModel
import com.arkivanov.mvikotlin.extensions.coroutines.bind
import com.arkivanov.mvikotlin.extensions.coroutines.states
import com.swallow.kmmrickandmorty.android.presentation.characters.mapper.charactersStateMapper
import com.swallow.kmmrickandmorty.android.presentation.characters.model.CharactersUiState
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.mapNotNull

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterViewModel(
    private val store: CharactersStore
) : ViewModel() {

    private val mutableState = MutableStateFlow(CharactersUiState())
    val state: Flow<CharactersUiState> = mutableState

    private fun acceptState(state: CharactersUiState) {
        mutableState.value = state
    }

    fun init() {
        bind {
            store.states.mapNotNull(charactersStateMapper) bindTo ::acceptState
        }.apply {
            start()
        }
    }

    fun loadingNextPage() {
        store.accept(CharactersStore.Intent.LoadingPage)
    }

    fun retry() {
        store.accept(CharactersStore.Intent.Retry)
    }
}
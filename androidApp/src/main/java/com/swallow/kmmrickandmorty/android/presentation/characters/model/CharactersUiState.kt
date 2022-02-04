package com.swallow.kmmrickandmorty.android.presentation.characters.model

import com.swallow.kmmrickandmorty.domain.common.LoadState

data class CharactersUiState(
    val items: List<UiCharacter> = emptyList(),
    val loadState: LoadState = LoadState.SuccessList
)
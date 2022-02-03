package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.core.store.Reducer

class CharacterReducerImpl : Reducer<CharactersStore.State, CharacterResult> {
    override fun CharactersStore.State.reduce(result: CharacterResult): CharactersStore.State =
        when (result) {
            is CharacterResult.Loaded -> copy(items = result.items)
            is CharacterResult.UpdateLoadState -> copy(loadState = result.loadState)
        }
}
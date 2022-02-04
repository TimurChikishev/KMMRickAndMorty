package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.core.store.Reducer

class CharacterReducerImpl : Reducer<CharactersStore.State, CharacterResult> {
    override fun CharactersStore.State.reduce(result: CharacterResult): CharactersStore.State =
        when (result) {
            is CharacterResult.Loaded -> copy(
                items = result.items.results,
                jsonInfo = result.items.info
            )
            is CharacterResult.LoadedPage -> copy(
                items = items + result.items.results,
                jsonInfo = result.items.info
            )
            is CharacterResult.UpdateLoadState -> copy(loadState = result.loadState)
        }
}
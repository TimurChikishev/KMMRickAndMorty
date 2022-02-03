package com.swallow.kmmrickandmorty.domain.mappers.characters

import com.swallow.kmmrickandmorty.domain.mvi_view.characters.CharactersView
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStore

val charactersStateToCharactersModel: CharactersStore.State.() -> CharactersView.Model? = {
    CharactersView.Model(items = items)
}
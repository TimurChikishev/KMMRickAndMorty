package com.swallow.kmmrickandmorty.domain.stores.characters

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter

sealed class CharacterResult {
    data class Loaded(val items: List<RemoteCharacter>) : CharacterResult()
}
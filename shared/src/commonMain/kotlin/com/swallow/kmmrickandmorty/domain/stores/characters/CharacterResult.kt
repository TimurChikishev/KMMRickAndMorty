package com.swallow.kmmrickandmorty.domain.stores.characters

import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.domain.common.LoadState

sealed class CharacterResult {
    data class Loaded(val items: List<RemoteCharacter>) : CharacterResult()
    data class UpdateLoadState(val loadState: LoadState) : CharacterResult()
}
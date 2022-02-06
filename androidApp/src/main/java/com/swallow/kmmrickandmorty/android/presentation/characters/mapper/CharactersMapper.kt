package com.swallow.kmmrickandmorty.android.presentation.characters.mapper

import com.swallow.kmmrickandmorty.android.presentation.characters.model.Character
import com.swallow.kmmrickandmorty.android.presentation.characters.model.CharacterLocation
import com.swallow.kmmrickandmorty.android.presentation.characters.model.CharacterOrigin
import com.swallow.kmmrickandmorty.android.presentation.characters.model.ListUiState
import com.swallow.kmmrickandmorty.android.presentation.common.mappers.StateMapper
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacterLocation
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacterOrigin
import com.swallow.kmmrickandmorty.domain.stores.common.ListStore

class CharactersMapper : StateMapper<ListStore.State<RemoteCharacter>, ListUiState<Character>> {

    override fun map(state: ListStore.State<RemoteCharacter>): ListUiState<Character> {
        return ListUiState(
            items = state.items.map { it.mapToUi },
            loadState = state.loadState
        )
    }

    private val RemoteCharacter.mapToUi: Character
        get() = Character(
            id = id,
            name = name,
            status = status,
            species = species,
            type = type,
            gender = gender,
            image = image,
            url = url,
            created = created,
            origin = origin.mapToUi,
            location = location.mapToUi,
            episode = episode
        )

    val RemoteCharacterOrigin.mapToUi: CharacterOrigin get() = CharacterOrigin(name, url)
    val RemoteCharacterLocation.mapToUi: CharacterLocation get() = CharacterLocation(name, url)
}



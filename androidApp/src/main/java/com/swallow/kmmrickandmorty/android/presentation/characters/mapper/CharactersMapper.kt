package com.swallow.kmmrickandmorty.android.presentation.characters.mapper

import com.swallow.kmmrickandmorty.android.presentation.characters.model.CharacterLocation
import com.swallow.kmmrickandmorty.android.presentation.characters.model.CharacterOrigin
import com.swallow.kmmrickandmorty.android.presentation.characters.model.CharactersUiState
import com.swallow.kmmrickandmorty.android.presentation.characters.model.UiCharacter
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacterLocation
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacterOrigin
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStore
import io.github.aakira.napier.Napier

val charactersStateMapper: CharactersStore.State.() -> CharactersUiState? = {
    CharactersUiState(
        items = items.map { it.mapToUi }
    )
}

val RemoteCharacter.mapToUi: UiCharacter
    get() = UiCharacter(
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



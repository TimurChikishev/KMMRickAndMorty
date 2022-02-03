package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.core.store.Store
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStore.*

interface CharactersStore : Store<Intent, State, Label> {

    sealed class Intent {
        object LoadingList : Intent()
    }

    data class State(
        val items: List<RemoteCharacter> = emptyList()
    )

    sealed class Label {
        data class Message(val message: String) : Label()
    }
}

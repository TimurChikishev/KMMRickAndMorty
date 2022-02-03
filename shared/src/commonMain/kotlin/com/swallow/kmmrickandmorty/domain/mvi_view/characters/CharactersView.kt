package com.swallow.kmmrickandmorty.domain.mvi_view.characters

import com.arkivanov.mvikotlin.core.view.MviView
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter


interface CharactersView : MviView<CharactersView.Model, CharactersView.Event> {
    data class Model(
        val items: List<RemoteCharacter>
    )

    sealed class Event {
        object LoadingList : Event()
    }
}
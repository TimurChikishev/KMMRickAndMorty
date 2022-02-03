package com.swallow.kmmrickandmorty.domain.mvi_view.characters

import com.arkivanov.mvikotlin.core.view.MviView


interface CharactersView : MviView<CharactersView.Model, CharactersView.Event> {
    data class Model(
        val items: List<Any>
    )

    sealed class Event {
        object LoadingList : Event()
    }
}
package com.swallow.kmmrickandmorty.domain.controller.characters

import com.arkivanov.mvikotlin.core.lifecycle.Lifecycle
import com.swallow.kmmrickandmorty.domain.mvi_view.characters.CharactersView

interface CharactersController {
    fun onViewCreated(
        charactersView: CharactersView,
        viewLifecycle: Lifecycle
    )

    sealed class Output {
        data class ItemSelected(val item: Any) : Output()
    }
}
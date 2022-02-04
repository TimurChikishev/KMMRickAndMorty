package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.core.store.Store
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter
import com.swallow.kmmrickandmorty.data.models.common.JsonInfo
import com.swallow.kmmrickandmorty.domain.common.LoadState
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStore.*

interface CharactersStore : Store<Intent, State, Label> {

    sealed class Intent {
        object LoadingList : Intent()
        object LoadingPage : Intent()
        object Retry : Intent()
    }

    data class State(
        val items: List<RemoteCharacter> = emptyList(),
        val loadState: LoadState = LoadState.SuccessList,
        val jsonInfo: JsonInfo = JsonInfo(
            count = 0,
            pages = 0,
            next = null,
            prev = null
        )
    )

    sealed class Label
}

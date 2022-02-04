package com.swallow.kmmrickandmorty.domain.stores.characters

import com.arkivanov.mvikotlin.extensions.coroutines.SuspendBootstrapper

class CharacterBootstrapperImpl : SuspendBootstrapper<CharacterAction>() {
    override suspend fun bootstrap() {
        dispatch(CharacterAction.Initial)
    }
}
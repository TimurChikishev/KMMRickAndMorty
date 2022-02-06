package com.swallow.kmmrickandmorty.domain.stores.common

import com.arkivanov.mvikotlin.extensions.coroutines.SuspendBootstrapper

class BootstrapperImpl : SuspendBootstrapper<Action>() {
    override suspend fun bootstrap() {
        dispatch(Action.Initial)
    }
}
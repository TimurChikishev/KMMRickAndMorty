package com.swallow.kmmrickandmorty.di

import io.github.aakira.napier.Napier
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    Napier.d(message = "initKoin")
    startKoin {
        appDeclaration()
        modules(
            appModuleShared,
            networkModule,
            repositoryModule,
        )
    }
}

// called by iOS
fun initKoinIos() = initKoin {}

expect fun koinPlatformModules(): List<Module>
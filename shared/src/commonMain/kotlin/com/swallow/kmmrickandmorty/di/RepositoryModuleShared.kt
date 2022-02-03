package com.swallow.kmmrickandmorty.di

import com.swallow.kmmrickandmorty.data.repository.CharacterRepositoryImpl
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import kotlinx.serialization.json.Json
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    single<CharacterRepository>{
        CharacterRepositoryImpl(
            httpClient = get(named(NetworkClient.CHARACTER))
        )
    }
}
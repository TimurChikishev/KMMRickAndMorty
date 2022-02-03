package com.swallow.kmmrickandmorty.android.di

import com.swallow.kmmrickandmorty.data.repository.CharacterRepositoryImpl
import com.swallow.kmmrickandmorty.domain.repository.CharacterRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<CharacterRepository>{ CharacterRepositoryImpl() }
}
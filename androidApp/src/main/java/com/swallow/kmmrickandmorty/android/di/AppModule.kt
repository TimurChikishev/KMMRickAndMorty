package com.swallow.kmmrickandmorty.android.di

import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.swallow.kmmrickandmorty.android.presentation.characters.fragments.CharacterViewModel
import com.swallow.kmmrickandmorty.domain.stores.characters.CharactersStoreFactory
import io.github.aakira.napier.Napier
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { CharacterViewModel(get()) }
}
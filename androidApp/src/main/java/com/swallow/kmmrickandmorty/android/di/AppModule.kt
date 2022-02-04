package com.swallow.kmmrickandmorty.android.di

import com.swallow.kmmrickandmorty.android.presentation.characters.fragments.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { CharacterViewModel(get()) }
}
package com.swallow.kmmrickandmorty.android.presentation.characters.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.arkivanov.mvikotlin.core.lifecycle.asMviLifecycle
import com.arkivanov.mvikotlin.keepers.instancekeeper.ExperimentalInstanceKeeperApi
import com.arkivanov.mvikotlin.keepers.instancekeeper.getInstanceKeeper
import com.swallow.kmmrickandmorty.android.R
import com.swallow.kmmrickandmorty.android.presentation.characters.mvi_view.CharactersViewImpl
import com.swallow.kmmrickandmorty.domain.controller.characters.CharactersCoroutinesController
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CharactersFragment : Fragment(R.layout.fragment_characters){

    @OptIn(ExperimentalInstanceKeeperApi::class)
    private val controller by inject<CharactersCoroutinesController> {
        parametersOf(getInstanceKeeper())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controller.onViewCreated(CharactersViewImpl(view), lifecycle.asMviLifecycle())
    }
}
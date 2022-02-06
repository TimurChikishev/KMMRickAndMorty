package com.swallow.kmmrickandmorty.android.presentation.characters.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.swallow.kmmrickandmorty.android.di.ViewModelType
import com.swallow.kmmrickandmorty.android.presentation.characters.model.Character
import com.swallow.kmmrickandmorty.android.presentation.characters.model.ListUiState
import com.swallow.kmmrickandmorty.android.presentation.common.fragments.ListFragment
import com.swallow.kmmrickandmorty.android.presentation.common.model.LoadStateItem
import com.swallow.kmmrickandmorty.android.utils.isOrientationPortrait
import com.swallow.kmmrickandmorty.data.models.characters.RemoteCharacter

class CharactersFragment
    : ListFragment<RemoteCharacter, Character, ListUiState<Character>>(ViewModelType.CHARACTER) {

    private val spanCount: Int
        get() = if (isOrientationPortrait) PORTRAIT_SPAN_COUNT else LAND_SPAN_COUNT

    override lateinit var linerLayoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initLinerLayout()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initLinerLayout() {
        linerLayoutManager = GridLayoutManager(context, spanCount).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (complexAdapter.items[position] is LoadStateItem) {
                        spanCount
                    } else {
                        ONE
                    }
                }
            }
        }
    }

    companion object {
        private const val PORTRAIT_SPAN_COUNT = 2
        private const val LAND_SPAN_COUNT = 3
        private const val ONE = 1
    }
}
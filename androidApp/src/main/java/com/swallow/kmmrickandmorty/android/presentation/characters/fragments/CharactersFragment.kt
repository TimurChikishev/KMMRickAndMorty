package com.swallow.kmmrickandmorty.android.presentation.characters.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.swallow.kmmrickandmorty.android.R
import com.swallow.kmmrickandmorty.android.databinding.FragmentCharactersBinding
import com.swallow.kmmrickandmorty.android.presentation.characters.adapters.ComplexDelegatesAdapter
import com.swallow.kmmrickandmorty.android.utils.autoCleared
import com.swallow.kmmrickandmorty.android.utils.isOrientationPortrait
import com.swallow.kmmrickandmorty.android.utils.launchOnStartedState
import io.github.aakira.napier.Napier
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment(R.layout.fragment_characters){

    private val binding by viewBinding(FragmentCharactersBinding::bind)
    private val characterViewModel by viewModel<CharacterViewModel>()
    private var complexAdapter by autoCleared<ComplexDelegatesAdapter>()

    private val spanCount: Int
        get() = if (isOrientationPortrait) PORTRAIT_SPAN_COUNT else LAND_SPAN_COUNT

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        initViewModel()
    }

    private fun setupAdapter() {
        complexAdapter = ComplexDelegatesAdapter()
        binding.recyclerView.apply {
            adapter = complexAdapter
            layoutManager = GridLayoutManager(context, spanCount)
            setHasFixedSize(true)
        }
    }

    private fun initViewModel() {
        characterViewModel.init()

        viewLifecycleOwner.launchOnStartedState {
            characterViewModel.state.collect { state ->
                state?.items?.forEach {
                    Napier.d(message = "$it", tag = "CHECK_LOG")
                }
                complexAdapter.items = state?.items
            }
        }
    }

    companion object {
        private const val PORTRAIT_SPAN_COUNT = 2
        private const val LAND_SPAN_COUNT = 3
    }
}
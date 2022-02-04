package com.swallow.kmmrickandmorty.android.presentation.characters.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.swallow.kmmrickandmorty.android.R
import com.swallow.kmmrickandmorty.android.databinding.FragmentCharactersBinding
import com.swallow.kmmrickandmorty.android.presentation.characters.adapters.ComplexDelegatesAdapter
import com.swallow.kmmrickandmorty.android.presentation.characters.model.CharactersUiState
import com.swallow.kmmrickandmorty.android.presentation.common.model.LoadStateItem
import com.swallow.kmmrickandmorty.android.utils.PaginationScrollListener
import com.swallow.kmmrickandmorty.android.utils.autoCleared
import com.swallow.kmmrickandmorty.android.utils.isOrientationPortrait
import com.swallow.kmmrickandmorty.android.utils.launchOnStartedState
import com.swallow.kmmrickandmorty.domain.common.LoadState
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val binding by viewBinding(FragmentCharactersBinding::bind)
    private val viewModel by viewModel<CharacterViewModel>()
    private var complexAdapter by autoCleared<ComplexDelegatesAdapter>()

    private val spanCount: Int
        get() = if (isOrientationPortrait) PORTRAIT_SPAN_COUNT else LAND_SPAN_COUNT

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        initListeners()
        initViewModel()
    }

    private fun initListeners() = with(binding) {
        plugImageView.setOnClickListener {
            viewModel.retry()
        }
    }

    private fun setupAdapter() {
        complexAdapter = ComplexDelegatesAdapter(
            retry = { viewModel.retry() }
        )

        val gridLayoutManager = GridLayoutManager(context, spanCount)

        binding.recyclerView.apply {
            adapter = complexAdapter
            layoutManager = gridLayoutManager
            setHasFixedSize(true)

            addOnScrollListener(
                PaginationScrollListener(
                    layoutManager = gridLayoutManager,
                    { viewModel.loadingNextPage() }
                )
            )
        }

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (complexAdapter.items[position] is LoadStateItem) {
                    spanCount
                } else {
                    ONE
                }
            }
        }
    }

    private fun initViewModel() {
        viewModel.init()

        viewLifecycleOwner.launchOnStartedState {
            viewModel.state.collect(::renderCharacters)
        }
    }

    private fun renderCharacters(state: CharactersUiState) {
        when (state.loadState) {
            is LoadState.LoadingList,
            is LoadState.ErrorList,
            is LoadState.SuccessList -> listStateRender(state)
            is LoadState.NextPageError,
            is LoadState.NextPageSuccess,
            is LoadState.LoadingPage -> pageStateRender(state)
        }
    }

    private fun listStateRender(state: CharactersUiState) {
        val isEmpty = complexAdapter.itemCount <= 0
        binding.progressBar.isVisible = state.loadState is LoadState.LoadingList && isEmpty
        binding.plugImageView.isVisible = state.loadState is LoadState.ErrorList && isEmpty
        complexAdapter.items = state.items
    }

    private fun pageStateRender(state: CharactersUiState) {
        complexAdapter.updateLoadStateItem(state)
    }

    companion object {
        private const val PORTRAIT_SPAN_COUNT = 2
        private const val LAND_SPAN_COUNT = 3
        private const val ONE = 1
    }
}
package com.swallow.kmmrickandmorty.android.presentation.common.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.swallow.kmmrickandmorty.android.R
import com.swallow.kmmrickandmorty.android.databinding.FragmentListBinding
import com.swallow.kmmrickandmorty.android.di.ViewModelType
import com.swallow.kmmrickandmorty.android.presentation.common.adapters.ComplexDelegatesAdapter
import com.swallow.kmmrickandmorty.android.presentation.common.model.ListState
import com.swallow.kmmrickandmorty.android.utils.PaginationScrollListener
import com.swallow.kmmrickandmorty.android.utils.autoCleared
import com.swallow.kmmrickandmorty.android.utils.launchOnStartedState
import com.swallow.kmmrickandmorty.domain.common.LoadState
import io.github.aakira.napier.Napier
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named

abstract class ListFragment<RemoteModel : Any, UiModel : Any, UiState : ListState<UiModel>>(viewModelName: ViewModelType) :
    Fragment(R.layout.fragment_list) {

    private val binding by viewBinding(FragmentListBinding::bind)
    private val viewModel by viewModel<ListFragmentViewModel<RemoteModel, UiState>>(named(viewModelName))
    protected var complexAdapter by autoCleared<ComplexDelegatesAdapter>()

    abstract var linerLayoutManager: LinearLayoutManager

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

        binding.recyclerView.apply {
            adapter = complexAdapter
            layoutManager = linerLayoutManager
            setHasFixedSize(true)

            addOnScrollListener(
                PaginationScrollListener(
                    layoutManager = linerLayoutManager,
                    { viewModel.loadingNextPage() }
                )
            )
        }
    }

    protected open fun initViewModel() {
        viewModel.init()

        viewLifecycleOwner.launchOnStartedState {
            viewModel.state.collect(::renderList)
        }
    }

    private fun renderList(state: UiState) {
        Napier.d(message = "ui state = ${state.items}")
        when (state.loadState) {
            is LoadState.LoadingList,
            is LoadState.ErrorList,
            is LoadState.SuccessList -> listStateRender(state)
            is LoadState.NextPageError,
            is LoadState.NextPageSuccess,
            is LoadState.LoadingPage -> pageStateRender(state)
        }
    }

    private fun listStateRender(state: UiState) {
        val isEmpty = complexAdapter.itemCount <= 0
        binding.progressBar.isVisible = state.loadState is LoadState.LoadingList && isEmpty
        binding.plugImageView.isVisible = state.loadState is LoadState.ErrorList && isEmpty
        complexAdapter.items = state.items
    }

    private fun pageStateRender(state: UiState) {
        if (complexAdapter.itemCount <= 0)
            complexAdapter.items = state.items

        complexAdapter.updateLoadStateItem(state)
    }
}
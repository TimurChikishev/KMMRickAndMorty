package com.swallow.kmmrickandmorty.android.presentation.characters.adapters.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.swallow.kmmrickandmorty.android.databinding.ItemLoadingPageBinding
import com.swallow.kmmrickandmorty.android.presentation.common.model.LoadStateItem
import com.swallow.kmmrickandmorty.domain.common.LoadState

class LoadStateItemDelegate(
    private val retry: () -> Unit
) : AbsListItemAdapterDelegate<Any, Any, LoadStateItemDelegate.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup) = Holder(
        ItemLoadingPageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), retry
    )

    override fun isForViewType(item: Any, items: MutableList<Any>, position: Int): Boolean {
        return item is LoadStateItem
    }

    override fun onBindViewHolder(
        item: Any,
        holder: Holder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item as LoadStateItem)
    }

    class Holder(
        private val binding: ItemLoadingPageBinding,
        private val listener: () -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.retryLoadingMoreButton.setOnClickListener {
                binding.retryLoadingMoreButton.isVisible = false
                binding.loadingItemProgressBar.isVisible = true
                listener.invoke()
            }
        }

        fun bind(item: LoadStateItem) = with(item) {
            binding.retryLoadingMoreButton.isVisible = loadState is LoadState.NextPageError
            binding.loadingItemProgressBar.isVisible = loadState is LoadState.LoadingPage
        }
    }
}


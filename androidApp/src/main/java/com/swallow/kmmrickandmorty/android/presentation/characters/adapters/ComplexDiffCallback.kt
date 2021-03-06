package com.swallow.kmmrickandmorty.android.presentation.characters.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.swallow.kmmrickandmorty.android.presentation.characters.model.UiCharacter

class ComplexDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(first: Any, second: Any): Boolean {
        return first.javaClass == second.javaClass && when (first) {
            is UiCharacter -> first.id == (second as UiCharacter).id
            else -> false
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(first: Any, second: Any) = first == second
}
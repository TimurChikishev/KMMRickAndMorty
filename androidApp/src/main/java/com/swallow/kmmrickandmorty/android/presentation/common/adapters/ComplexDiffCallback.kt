package com.swallow.kmmrickandmorty.android.presentation.common.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.swallow.kmmrickandmorty.android.presentation.characters.model.Character
import com.swallow.kmmrickandmorty.android.presentation.episodes.models.Episode
import com.swallow.kmmrickandmorty.android.presentation.locations.model.Locations

class ComplexDiffCallback : DiffUtil.ItemCallback<Any>() {
    override fun areItemsTheSame(first: Any, second: Any): Boolean {
        return first.javaClass == second.javaClass && when (first) {
            is Character -> first.id == (second as Character).id
            is Locations -> first.id == (second as Locations).id
            is Episode -> first.id == (second as Episode).id
            else -> false
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(first: Any, second: Any) = first == second
}
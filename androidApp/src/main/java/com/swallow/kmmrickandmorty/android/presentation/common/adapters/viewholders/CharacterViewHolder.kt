package com.swallow.kmmrickandmorty.android.presentation.common.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swallow.kmmrickandmorty.android.databinding.ItemCharactersBinding
import com.swallow.kmmrickandmorty.android.presentation.characters.model.Character

class CharacterViewHolder(
    private val viewBinding: ItemCharactersBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    companion object {
        private const val IMAGE_SIZE: Int = 300
    }

    fun bind(model: Character) = with(model) {
        setAvatarImage(image)
        setName(name)
    }

    private fun setName(name: String) {
        viewBinding.nameTextView.text = name
    }

    private fun setAvatarImage(image: String) = with(viewBinding) {
        Glide.with(avatarImageView)
            .load(image)
            .override(IMAGE_SIZE)
            .into(avatarImageView)
    }
}
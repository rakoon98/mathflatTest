package com.example.mathflat.ui.litmus.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.mathflat.databinding.HolderLitmusTitleBinding
import com.example.mathflat.model.data.PieceTitle

class LitmusTitleHolder(
    private val holderLitmusTitleBinding: HolderLitmusTitleBinding
) : RecyclerView.ViewHolder(holderLitmusTitleBinding.root) {
    fun bind(pieceTitle: PieceTitle){
        holderLitmusTitleBinding.apply {
            item = pieceTitle
            executePendingBindings()
        }
    }
}
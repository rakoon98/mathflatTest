package com.example.mathflat.ui.main.learning.adapter

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.mathflat.databinding.HolderLearningItemBinding
import com.example.mathflat.model.data.PieceData
import com.example.mathflat.ui.litmus.LitmusActivity

class LearningHolder (
    val view:HolderLearningItemBinding
): RecyclerView.ViewHolder(view.root) {
    fun bind(pieceData: PieceData){
        view.apply {
            item = pieceData

            learningItemBox.setOnClickListener {
                it.context.startActivity(
                    Intent(it.context, LitmusActivity::class.java).apply {
                        putExtra("PieceDataId",pieceData.id)
                    }
                )
            }

            executePendingBindings()
        }
    }
}
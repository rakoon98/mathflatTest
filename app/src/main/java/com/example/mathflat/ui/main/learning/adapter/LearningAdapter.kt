package com.example.mathflat.ui.main.learning.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mathflat.R
import com.example.mathflat.databinding.HolderLearningEmptyBinding
import com.example.mathflat.model.data.PieceData

class LearningAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var learningItems = mutableListOf<Any>()

    override fun getItemViewType(position: Int): Int {
        return when(learningItems[position]){
            is PieceData -> 1
            else -> 0
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            1-> { LearningHolder( DataBindingUtil.inflate(inflater, R.layout.holder_learning_item, parent, false) ) }
            else -> { EmptyHolder( HolderLearningEmptyBinding.inflate(inflater) ) }
        }
    }
    override fun getItemCount(): Int = learningItems.size ?: 0
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var posItem = learningItems[position]
        when( posItem ){
            is PieceData -> { (holder as LearningHolder).bind(posItem) }
            else -> {  }
        }
    }
}
package com.example.mathflat.ui.litmus.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mathflat.R
import com.example.mathflat.databinding.HolderLearningEmptyBinding
import com.example.mathflat.model.data.PieceDataOne
import com.example.mathflat.model.data.PieceTitle
import com.example.mathflat.ui.main.learning.adapter.EmptyHolder
import com.example.mathflat.util.VerificationCheckResult
import com.example.mathflat.util.VerificationMyAnswerHaveNull
import com.example.mathflat.viewmodel.litmus.LitmusViewmodel

class LitmusAdapter(
    val litmusBtnInterface: LitmusBtnInterace
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val litmusInterface = object : LitmusInterface{
        override fun LitmusAnswerCheckSelectable(answer: Int?, position: Int) {
            // 정답을 해당 포지션에 넣어준 후 채점시 참고하기 위함 : 객관식
            var item = litmusItems[position] as PieceDataOne
            item.myAnswer = answer

            litmusBtnInterface.setEnabledSubmitBtn(VerificationMyAnswerHaveNull(litmusItems))
        }

        override fun LitmusAnswerCheck(answer: Int?, position: Int) {
            // 정답을 해당 포지션에 넣어준 후 채점시 참고하기 위함 : 주관식
            var item = litmusItems[position] as PieceDataOne
            item.myAnswer = answer

            litmusBtnInterface.setEnabledSubmitBtn(VerificationMyAnswerHaveNull(litmusItems))
        }
    }

    var litmusItems = mutableListOf<Any>()

    fun showAllLitmus(isShow:Boolean){
        litmusItems.forEachIndexed { index, any ->
            if( any is PieceDataOne ) {
                any.isShow = isShow
                notifyItemChanged(index)
            }
        }
    }

    fun submitLitmus(){
        litmusItems.forEachIndexed { index, any ->
            if( any is PieceDataOne ) {
                any.submit = true
                notifyItemChanged(index)
            }
        }

        litmusBtnInterface.setResult(VerificationCheckResult(litmusItems))
    }

    override fun getItemViewType(position: Int): Int {
        return when(litmusItems[position]){
            is PieceDataOne -> {
                if( (litmusItems[position] as PieceDataOne).isSelectable  ){
                    2
                } else {
                    3
                }
            }
            is PieceTitle -> { 1 }
            else -> { 0 }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            1->{
                LitmusTitleHolder(DataBindingUtil.inflate(inflater, R.layout.holder_litmus_title, parent, false))
            }
            2->{
                LitmusOneSelectableHolder(DataBindingUtil.inflate(inflater, R.layout.holder_litmus_selectable_one_item, parent, false),litmusInterface)
            }
            3->{
                LitmusOneUnSelectableHolder(DataBindingUtil.inflate(inflater, R.layout.holder_litmus_un_selectable_one_item, parent, false),litmusInterface)
            }
            else->{
                EmptyHolder( HolderLearningEmptyBinding.inflate(inflater) )
            }
        }
    }

    override fun getItemCount(): Int = litmusItems.size ?: 0

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(litmusItems[position]){
            is PieceDataOne -> {
                when(holder){
                    is LitmusOneSelectableHolder ->{
                        holder.bind(litmusItems[position] as PieceDataOne,position)
                    }
                    is LitmusOneUnSelectableHolder ->{
                        holder.bind(litmusItems[position] as PieceDataOne,position)
                    }
                }
            }
            is PieceTitle -> {
                (holder as LitmusTitleHolder).bind(litmusItems[position] as PieceTitle)
            }
        }
    }

}
package com.example.mathflat.model.comp

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mathflat.model.data.PieceDataAll
import com.example.mathflat.model.data.PieceTitle
import com.example.mathflat.ui.litmus.adapter.LitmusAdapter
import com.example.mathflat.ui.main.learning.adapter.LearningAdapter

class AdapterComp {
    companion object {
        @JvmStatic
        @BindingAdapter("bindItems")
        fun setBindItem(view: RecyclerView, data: MutableList<Any>?) {
            view.adapter?.run {
                when(this){
                    is LearningAdapter -> {
                        Log.d("콜합니다","[유틸] $data")
                        data?.let { checkData ->
                            learningItems = checkData
                            notifyDataSetChanged()
                        }
                    }
                    else -> {}
                }
            }
        }

        @JvmStatic
        @BindingAdapter("bindItemsLitmus")
        fun setBindItemLitmus(view: RecyclerView, data: PieceDataAll?) {
            view.adapter?.run {
                when(this){
                    is LitmusAdapter -> {
                        data?.let { checkData ->
                            litmusItems.add( PieceTitle(checkData.title) )
                            notifyItemInserted(litmusItems.size-1)
                            notifyItemChanged(litmusItems.size-1)

                            checkData.problems.forEachIndexed { index, pieceDataOne ->
                                litmusItems.add(pieceDataOne)
                                notifyItemInserted(litmusItems.size-1)
                                notifyItemChanged(litmusItems.size-1)
                            }

                        }
                    }
                    else -> {}
                }
            }
        }
    }
}
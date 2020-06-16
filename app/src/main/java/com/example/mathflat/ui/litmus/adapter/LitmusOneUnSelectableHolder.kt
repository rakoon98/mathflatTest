package com.example.mathflat.ui.litmus.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mathflat.databinding.HolderLitmusUnSelectableOneItemBinding
import com.example.mathflat.model.data.PieceDataOne

class LitmusOneUnSelectableHolder(
    private val holderLitmusUnSelectableItemBinding: HolderLitmusUnSelectableOneItemBinding,
    private val litmusInterface: LitmusInterface
) : RecyclerView.ViewHolder(holderLitmusUnSelectableItemBinding.root) {
    fun bind(pieceDataOne: PieceDataOne,position:Int){
        holderLitmusUnSelectableItemBinding.apply {
            item = pieceDataOne
            number = position

            if(pieceDataOne.submit){
                if(pieceDataOne.answer==pieceDataOne.myAnswer){
                    answerResultCorrectBox.visibility = View.VISIBLE
                    answerResultInCorrectBox.visibility = View.GONE
                    answerBox.visibility = View.GONE
                }else{
                    answerResultCorrectBox.visibility = View.GONE
                    answerResultInCorrectBox.visibility = View.VISIBLE
                    answerBox.visibility = View.GONE
                }
            } else {
                answerResultCorrectBox.visibility = View.GONE
                answerResultInCorrectBox.visibility = View.GONE
                answerBox.visibility = View.VISIBLE
            }

            answerEt.addTextChangedListener( object : TextWatcher{
                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if(s.isNullOrEmpty()){
                        litmusInterface.LitmusAnswerCheck( null , position)
                    } else {
                        litmusInterface.LitmusAnswerCheck( s.toString().toInt(), position)
                    }
                }
            } )

            executePendingBindings()
        }
    }

}
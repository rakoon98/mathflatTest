package com.example.mathflat.ui.litmus.adapter

import android.view.View
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.example.mathflat.databinding.HolderLitmusSelectableOneItemBinding
import com.example.mathflat.model.data.PieceDataOne

class LitmusOneSelectableHolder(
    private val holderLitmusSelectableOneItemBinding: HolderLitmusSelectableOneItemBinding,
    private val litmusInterface: LitmusInterface
) : RecyclerView.ViewHolder(holderLitmusSelectableOneItemBinding.root) {
    var toggleList = mutableListOf<ToggleButton>()
    fun bind(pieceDataOne: PieceDataOne,position:Int){
        holderLitmusSelectableOneItemBinding.apply {
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

            toggleList.add(answerOne)
            toggleList.add(answerTwo)
            toggleList.add(answerThree)
            toggleList.add(answerFour)
            toggleList.add(answerFive)

            answerOne.toggleListener(position)
            answerTwo.toggleListener(position)
            answerThree.toggleListener(position)
            answerFour.toggleListener(position)
            answerFive.toggleListener(position)

            executePendingBindings()
        }
    }

    private fun ToggleButton.toggleListener(position : Int) =
        this.setOnCheckedChangeListener { buttonView, isChecked ->
            toggleList.forEach { it.isChecked = false }

            if(isChecked){
                buttonView.isChecked = true
                litmusInterface.LitmusAnswerCheckSelectable("${buttonView.text}".toInt(), position)
            } else {
                litmusInterface.LitmusAnswerCheckSelectable(null, position)
            }
        }
}
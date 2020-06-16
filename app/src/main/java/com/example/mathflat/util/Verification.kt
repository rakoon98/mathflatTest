package com.example.mathflat.util

import android.util.Log
import com.example.mathflat.model.data.PieceDataOne

fun VerificationMyAnswerHaveNull(list: MutableList<Any>): Boolean {
    var returnValue = true

    list.forEachIndexed { index, any ->
        if (any is PieceDataOne) {
            if (any.myAnswer == null) {
                returnValue = false
                return@forEachIndexed
            }
        }
    }


    return returnValue
}

fun VerificationCheckResult(list: MutableList<Any>): String {
    var countAll = 0
    var countCorrect = 0

    list.forEachIndexed { index, any ->
        if (any is PieceDataOne) {
            Log.d("뿌아아앙","${any.myAnswer}----${any.answer}")
            countAll++
            if (any.myAnswer == any.answer) {
                Log.d("뿌아아앙","뭐지???")
                countCorrect++
            }
        }
    }

    var checkScore = (100/countAll) * countCorrect
    Log.d("뿌아아앙","$countAll -----  $countCorrect ==> $checkScore")

    return "${countAll}문제·${checkScore}점"
}

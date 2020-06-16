package com.example.mathflat.model.data

import android.view.View

// "id": 1,
// "title": "2019년 6월 평가원 모의고사 - 이과",
// "date": "2019-06-12",
// "problemCount": 5,
// "isFavorite": false
data class PieceData(
    val id : Int,
    val title : String,
    val date : String,
    val problemCount : Int,
    val isFavorite : Boolean
)

data class PieceDataAll(
    val id : Int,
    val title : String,
    val problems : MutableList<PieceDataOne>
)
data class PieceDataOne(
    val problemId:Int,
    val problemUrl : String,
    val isSelectable:Boolean,
    var myAnswer : Int?=null, // 내가 고른 정답
    val answer : Int, // 정답
    var isShow : Boolean = false,
    var submit : Boolean = false
) {
    var resultCheckInCorrect = if(submit) {
        myAnswer?.let {
            if(it==answer) View.VISIBLE else View.INVISIBLE
        } ?: View.INVISIBLE
    } else {
        View.INVISIBLE
    }
    var resultCheckCorrect = if(submit) {
        myAnswer?.let {
            if(it==answer) View.INVISIBLE else View.VISIBLE
        } ?: View.INVISIBLE
    } else {
        View.INVISIBLE
    }
    var resultCheckProblem = if(submit) {
        myAnswer?.let {
            if(it==answer) View.INVISIBLE else View.INVISIBLE
        } ?: View.VISIBLE
    } else {
        View.VISIBLE
    }

}

data class PieceTitle(
    val title : String
)
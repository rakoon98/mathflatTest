package com.example.mathflat.viewmodel.learning

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathflat.model.data.PieceData
import com.example.mathflat.model.network.ResultConverter
import com.example.mathflat.model.repositories.learning.LearningRepository
import kotlinx.coroutines.launch

class LearningViewmodel(
    val repository: LearningRepository
) : ViewModel() {

    val piecesData = MutableLiveData<MutableList<Any>>()

    fun getPieces() {
        viewModelScope.launch {
            val response = repository.getPieces()
            if(response is ResultConverter.Success ){
                response.data.run {
                    Log.d("콜합니다","[성공] $response")
//                    piecesData.postValue(this)
                    val before = piecesData.value ?: mutableListOf()
                    this.forEach { before.add(it) }
                    piecesData.postValue(before)
                }
            } else if ( response is ResultConverter.Error ){
                Log.d("콜합니다","[에러] $response")
            }
        }
    }
}
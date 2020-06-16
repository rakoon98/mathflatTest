package com.example.mathflat.viewmodel.litmus

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mathflat.model.data.PieceDataAll
import com.example.mathflat.model.network.ResultConverter
import com.example.mathflat.model.repositories.litmus.LitmusRepository
import kotlinx.coroutines.launch

class LitmusViewmodel(
    val litmusRepository: LitmusRepository
) : ViewModel() {

    val getPiecesContactIdData = MutableLiveData<PieceDataAll>()

    fun getPiecesContactId(id: Int) {
        viewModelScope.launch {
            val response = litmusRepository.getPiecesContactId(id)
            if ( response is ResultConverter.Success ) {
                getPiecesContactIdData.postValue(response.data)
            } else if ( response is ResultConverter.Error ) {
                // 에러
            }
        }
    }
}
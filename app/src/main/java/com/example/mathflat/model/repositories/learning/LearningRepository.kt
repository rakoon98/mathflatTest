package com.example.mathflat.model.repositories.learning

import android.util.Log
import com.example.mathflat.model.data.PieceData
import com.example.mathflat.model.network.MathFlatInterface
import com.example.mathflat.model.network.ResultConverter
import kotlinx.coroutines.*
import retrofit2.HttpException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LearningRepository(
    private val mathFlatInterface: MathFlatInterface
) : LearningRepositoryImpl {
    override suspend fun getPieces() = suspendCoroutine<ResultConverter<MutableList<PieceData>>> { continuation ->
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val request = mathFlatInterface.getPieces()
                if (request.code() == 200) {
                    continuation.resume(ResultConverter.Success(request.body()!!))
                } else {
                    throw HttpException(request)
                }
            }catch (e:Exception){
                continuation.resume(ResultConverter.Error(e))
            }
        }
    }
}
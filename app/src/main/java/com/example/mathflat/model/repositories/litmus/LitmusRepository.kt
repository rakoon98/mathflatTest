package com.example.mathflat.model.repositories.litmus

import com.example.mathflat.model.data.PieceDataAll
import com.example.mathflat.model.network.MathFlatInterface
import com.example.mathflat.model.network.ResultConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LitmusRepository(
    private val mathFlatInterface: MathFlatInterface
) : LitmusRepositoryImpl {
    override suspend fun getPiecesContactId(id:Int): ResultConverter<PieceDataAll>
            = suspendCoroutine { continuation ->
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val request = mathFlatInterface.getPiecesContactId(id)
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
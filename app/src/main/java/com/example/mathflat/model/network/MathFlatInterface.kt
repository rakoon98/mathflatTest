package com.example.mathflat.model.network

import com.example.mathflat.model.data.PieceData
import com.example.mathflat.model.data.PieceDataAll
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *  getPieces : 각 시험지 리스트
 *  getPiecesContactId : 각 시험지 내부의 문제들
 */
interface MathFlatInterface {
    @GET("/pieces")
    suspend fun getPieces() : Response<MutableList<PieceData>>

    @GET("/pieces/{id}")
    suspend fun getPiecesContactId(
        @Path("id") id: Int
    ) : Response<PieceDataAll>
}
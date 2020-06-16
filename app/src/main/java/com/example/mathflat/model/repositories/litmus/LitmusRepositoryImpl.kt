package com.example.mathflat.model.repositories.litmus

import com.example.mathflat.model.data.PieceDataAll
import com.example.mathflat.model.network.ResultConverter

interface LitmusRepositoryImpl {
    suspend fun getPiecesContactId(id:Int) : ResultConverter< PieceDataAll >
}
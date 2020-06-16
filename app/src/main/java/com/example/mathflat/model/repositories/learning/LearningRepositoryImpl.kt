package com.example.mathflat.model.repositories.learning

import com.example.mathflat.model.data.PieceData
import com.example.mathflat.model.network.ResultConverter

interface LearningRepositoryImpl {
    suspend fun getPieces() : ResultConverter<MutableList<PieceData>>
}
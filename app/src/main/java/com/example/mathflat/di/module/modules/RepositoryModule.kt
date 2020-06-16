package com.example.mathflat.di.module.modules

import com.example.mathflat.model.repositories.learning.LearningRepository
import com.example.mathflat.model.repositories.learning.LearningRepositoryImpl
import com.example.mathflat.model.repositories.litmus.LitmusRepository
import com.example.mathflat.viewmodel.learning.LearningViewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single { LearningRepository(get()) }
    single { LitmusRepository(get()) }
}
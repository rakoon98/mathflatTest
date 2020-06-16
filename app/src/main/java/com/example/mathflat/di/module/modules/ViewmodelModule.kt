package com.example.mathflat.di.module.modules

import com.example.mathflat.viewmodel.learning.LearningViewmodel
import com.example.mathflat.viewmodel.litmus.LitmusViewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { LearningViewmodel(get()) }
    viewModel { LitmusViewmodel(get()) }
}
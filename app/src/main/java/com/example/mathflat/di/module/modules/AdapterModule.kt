package com.example.mathflat.di.module.modules

import com.example.mathflat.ui.litmus.adapter.LitmusAdapter
import com.example.mathflat.ui.litmus.adapter.LitmusBtnInterace
import com.example.mathflat.ui.main.learning.adapter.LearningAdapter
import org.koin.dsl.module

val adapterModule = module {
    factory { LearningAdapter() }
    factory { (litmusBtnInterface : LitmusBtnInterace)->LitmusAdapter( litmusBtnInterface ) }
}
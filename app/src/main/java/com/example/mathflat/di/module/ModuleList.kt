package com.example.mathflat.di.module

import com.example.mathflat.di.module.modules.adapterModule
import com.example.mathflat.di.module.modules.networkModule
import com.example.mathflat.di.module.modules.repositoryModule
import com.example.mathflat.di.module.modules.viewmodelModule

val moduleList = listOf(
    networkModule,
    viewmodelModule,
    repositoryModule,
    adapterModule
)
package com.blopez.kotlinmvvmjetpackkoin.di

import com.blopez.kotlinmvvmjetpackkoin.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val homeModule: Module = module {
    viewModel { HomeViewModel() }
}
package com.blopez.kotlinmvvmjetpackkoin.di

import com.blopez.kotlinmvvmjetpackkoin.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val mainModule: Module = module {
    viewModel { MainViewModel() }
}
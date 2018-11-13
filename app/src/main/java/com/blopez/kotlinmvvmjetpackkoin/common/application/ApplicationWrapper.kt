package com.blopez.kotlinmvvmjetpackkoin.common.application

import android.app.Application
import com.blopez.kotlinmvvmjetpackkoin.di.appModule
import com.blopez.kotlinmvvmjetpackkoin.di.homeModule
import com.blopez.kotlinmvvmjetpackkoin.di.mainModule
import org.koin.android.ext.android.startKoin

class ApplicationWrapper : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, mainModule, homeModule))
    }

}
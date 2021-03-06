package com.blopez.kotlinmvvmjetpackkoin.ui.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.blopez.kotlinmvvmjetpackkoin.common.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    val title = MutableLiveData<String>()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        title.value = "hola"
    }
}

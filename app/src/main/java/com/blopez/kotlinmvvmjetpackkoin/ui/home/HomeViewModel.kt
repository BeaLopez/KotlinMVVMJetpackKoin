package com.blopez.kotlinmvvmjetpackkoin.ui.home

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.blopez.kotlinmvvmjetpackkoin.common.base.BaseViewModel

class HomeViewModel : BaseViewModel() {

    val clicksCount = MutableLiveData<Int>()

    fun onClickButton() {
        clicksCount.value = clicksCount.value?.plus(1)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        clicksCount.value = 0
    }
}

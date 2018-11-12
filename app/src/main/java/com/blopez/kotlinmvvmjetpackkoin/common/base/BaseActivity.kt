package com.blopez.kotlinmvvmjetpackkoin.common.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<T : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    private lateinit var mViewDataBinding: T
    private lateinit var mViewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mViewModel = getViewModel()
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
        lifecycle.addObserver(mViewModel)
        attachObserver()
    }

    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    //To ensure the Back button works properly
    abstract override fun onSupportNavigateUp(): Boolean

    abstract fun getViewModel(): V
    abstract fun getLayoutId(): Int
    abstract fun getBindingVariable(): Int
    abstract fun attachObserver()

}
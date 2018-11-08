package com.blopez.kotlinmvvmjetpackkoin.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    private lateinit var mActivity: BaseActivity<*, *>
    private lateinit var mViewDataBinding: T
    private lateinit var mViewModel: V

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return mViewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = getViewModel()
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mActivity = activity as BaseActivity<*, *>
        lifecycle.addObserver(mViewModel)
        attachObserver()
    }

    fun getBaseActivity(): BaseActivity<*, *> {
        return mActivity
    }

    fun getViewDataBinding(): T {
        return mViewDataBinding
    }

    abstract fun getViewModel(): V
    abstract fun getLayoutId(): Int
    abstract fun getBindingVariable(): Int
    abstract fun attachObserver()
}
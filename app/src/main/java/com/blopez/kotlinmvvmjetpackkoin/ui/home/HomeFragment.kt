package com.blopez.kotlinmvvmjetpackkoin.ui.home

import androidx.lifecycle.Observer
import com.blopez.kotlinmvvmjetpackkoin.BR
import com.blopez.kotlinmvvmjetpackkoin.R
import com.blopez.kotlinmvvmjetpackkoin.common.base.BaseFragment
import com.blopez.kotlinmvvmjetpackkoin.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    private val mViewModel: HomeViewModel by viewModel()

    override fun attachObserver() {

        //Example: Observe clicksCount variable
        mViewModel.clicksCount.observe(this, Observer<Int> { value ->
            value?.let { setText(it) }
        })
    }

    override fun getBindingVariable(): Int {
        return BR.homeViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun getViewModel(): HomeViewModel {
        return mViewModel
    }

    private fun setText(value: Int) {
        tv_prueba.text = value.toString()
    }

}

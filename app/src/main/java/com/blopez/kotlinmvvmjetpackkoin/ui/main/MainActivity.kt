package com.blopez.kotlinmvvmjetpackkoin.ui.main

import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.blopez.kotlinmvvmjetpackkoin.BR
import com.blopez.kotlinmvvmjetpackkoin.R
import com.blopez.kotlinmvvmjetpackkoin.common.base.BaseActivity
import com.blopez.kotlinmvvmjetpackkoin.databinding.MainActivityBinding
import kotlinx.android.synthetic.main.main_activity.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    private val mViewModel: MainViewModel by viewModel()

    override fun onSupportNavigateUp() = Navigation.findNavController(this, R.id.navHostFragment).navigateUp()


    override fun getViewModel(): MainViewModel {
        return mViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.main_activity
    }

    override fun getBindingVariable(): Int {
        return BR.mainViewModel
    }

    override fun attachObserver() {

        //Example: Observe title variable
        mViewModel.title.observe(this, Observer<String> { value ->
            value?.let { tv_title.text = it }
        })

    }
}
